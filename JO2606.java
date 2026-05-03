import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO2606 {
    static int[][][] map;
    static boolean[][][] isVisited;
    static int[][][] dist;
    static int n, m, k;
    static int[] dx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] dy = new int[]{0, -1, 0, 1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[k][n][m];
        isVisited = new boolean[k][n][m];
        dist = new int[k][n][m];
        Queue<int[]> q = new LinkedList<>();
        int a = 0;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int p = 0; p < m; p++){
                    map[i][j][p] = Integer.parseInt(st.nextToken());
                    if(map[i][j][p] == 1) {
                        q.add(new int[]{i, j, p});
                        isVisited[i][j][p] = true;
                    } else if(map[i][j][p] == 0){
                        a++;
                    }
                }
            }
        }
        if(a == 0){
            System.out.println(0);
            return ;
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur_z = node[0];
            int cur_x = node[1];
            int cur_y = node[2];
            for(int dir = 0; dir < 6; dir++){
                int nz = cur_z + dz[dir];
                int nx = cur_x + dx[dir];
                int ny = cur_y + dy[dir];
                if(nz < 0 || nz >= k || nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nz][nx][ny] || map[nz][nx][ny] == -1) continue;
                isVisited[nz][nx][ny] = true;
                q.add(new int[]{nz, nx, ny});
                dist[nz][nx][ny] = dist[cur_z][cur_x][cur_y] + 1;
            }
        }
        int Max = Integer.MIN_VALUE;
        boolean cant = false;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                for(int p = 0; p < m; p++){
                    if(dist[i][j][p] > Max) {
                        Max = dist[i][j][p];
                    }
                    if(map[i][j][p] == 0 && dist[i][j][p] == 0){
                        cant = true;
                    }
                }
            }
        }

        if(!cant){
            System.out.println(Max);
        } else {
            System.out.println(-1);
        }
    }

}
