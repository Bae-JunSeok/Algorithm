import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO3682 {
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'c') {
                    map[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int x = node[0];
            int y = node[1];
            int nextY = y + 1;

            if (nextY >= m) {
                continue;
            }

            if (map[x][nextY] != -1) {
                continue;
            }

            map[x][nextY] = map[x][y] + 1;
            q.offer(new int[]{x, nextY});
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    sb.append(' ');
                }

                sb.append(map[i][j]);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}