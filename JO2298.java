import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO2298 {
    static int n;
    static int k = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > k) k = map[i][j];
            }
        }

        for(int i = k; i > -1; i--){
            int count = 0;
            isVisited = new boolean[n][n];
            for(int j = 0; j < n; j++){
                for(int p = 0; p < n; p++){
                    if(!isVisited[j][p] && map[j][p] > i){
                        bfs(j, p, i);
                        count++;
                    }
                }
            }
            if(count > Max) Max = count;
        }

        System.out.println(Max);

    }


    static void bfs(int startX, int startY, int o){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        isVisited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] <= o) continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
            }
        }
    }
}
