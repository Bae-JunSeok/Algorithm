import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO4013 {
    static int n, t;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][][] dist;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dijkstra(0, 0);

        int answer = Math.min(
                dist[n - 1][n - 1][0],
                Math.min(dist[n - 1][n - 1][1], dist[n - 1][n - 1][2])
        );

        System.out.println(answer);
    }

    static void Dijkstra(int startX, int startY){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });

        dist = new int[n][n][3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], INF);
            }
        }

        dist[startX][startY][0] = 0;
        pq.add(new int[]{startX, startY, 0, 0});
        // x, y, 현재 비용, 이동 횟수 % 3

        while (!pq.isEmpty()) {
            int[] node = pq.poll();

            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];
            int curCount = node[3];

            if(curDist > dist[curX][curY][curCount]) continue;

            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                int nextCount = (curCount + 1) % 3;
                int nextDist = curDist + t;

                // 3번째 이동이면 도착 칸의 풀 비용 추가
                if(nextCount == 0){
                    nextDist += map[nx][ny];
                }

                if(dist[nx][ny][nextCount] > nextDist){
                    dist[nx][ny][nextCount] = nextDist;
                    pq.add(new int[]{nx, ny, nextDist, nextCount});
                }
            }
        }
    }
}