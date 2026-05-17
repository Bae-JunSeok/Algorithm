import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1008 {
    static int n, t;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == -2) {
                    endX = i;
                    endY = j;
                }
            }
        }

        int answer = solve(startX, startY, endX, endY);

        System.out.println(answer);
    }

    static int solve(int startX, int startY, int endX, int endY) {
        int[][] cur = new int[n][n];
        int[][] next = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cur[i], INF);
            Arrays.fill(next[i], INF);
        }

        cur[startX][startY] = 0;

        int answer = INF;

        // 0분에 이미 도착지인 경우
        if (startX == endX && startY == endY) {
            answer = 0;
        }

        for (int time = 1; time <= t; time++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(next[i], INF);
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (cur[x][y] == INF) {
                        continue;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }

                        // 건물
                        if (map[nx][ny] == 0) {
                            continue;
                        }

                        int cost = map[nx][ny];

                        // 출발점 -1, 도착점 -2는 일사량 0으로 처리
                        if (cost < 0) {
                            cost = 0;
                        }

                        if (next[nx][ny] > cur[x][y] + cost) {
                            next[nx][ny] = cur[x][y] + cost;
                        }
                    }
                }
            }

            answer = Math.min(answer, next[endX][endY]);

            int[][] temp = cur;
            cur = next;
            next = temp;
        }

        if (answer == INF) {
            return -1;
        }

        return answer;
    }
}