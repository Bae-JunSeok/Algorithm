import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class JO1696 {
    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int max = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
                dist[i][j] = max;
            }
        }

        Dijkstra(0, 0);

        System.out.println(dist[n - 1][n - 1]);
    }

    static void Dijkstra(int startX, int startY) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[startX][startY] = 0;
        pq.add(new int[]{startX, startY, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();

            int curX = node[0];
            int curY = node[1];
            int curCost = node[2];

            if (curCost > dist[curX][curY]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                int cost;

                if (map[nx][ny] == 1) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                if (dist[nx][ny] > dist[curX][curY] + cost) {
                    dist[nx][ny] = dist[curX][curY] + cost;
                    pq.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
    }
}