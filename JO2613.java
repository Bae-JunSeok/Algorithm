import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO2613 {
    static int n, m;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] map;
    static int[][] dist;
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        isVisited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        boolean hasUnripeTomato = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    // 여러 개의 익은 토마토를 모두 시작점으로 넣음
                    q.add(new int[]{i, j});
                    isVisited[i][j] = true;
                } else if (map[i][j] == 0) {
                    hasUnripeTomato = true;
                }
            }
        }

        // 처음부터 익지 않은 토마토가 하나도 없는 경우
        if (!hasUnripeTomato) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int curX = node[0];
            int curY = node[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 빈칸이거나 이미 방문한 곳이면 이동하지 않음
                if (map[nx][ny] == -1 || isVisited[nx][ny]) {
                    continue;
                }

                isVisited[nx][ny] = true;
                dist[nx][ny] = dist[curX][curY] + 1;

                q.add(new int[]{nx, ny});
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 원래 익지 않은 토마토였는데 방문하지 못했다면
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);
    }
}