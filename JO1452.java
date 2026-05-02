import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1452 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dist;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = input[j].charAt(0);
            }
        }
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'L'){
                    int result = bfs(i, j);
                    if(result > Max) Max = result;
                }
            }
        }
        System.out.println(Max);
    }

    static int bfs(int startX, int startY){
        isVisited = new boolean[n][m];
        dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        isVisited[startX][startY] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur_x = node[0];
            int cur_y = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = cur_x + dx[dir];
                int ny = cur_y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == 'W') continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
                dist[nx][ny] = dist[cur_x][cur_y] + 1;
            }
        }
        int r = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dist[i][j] > r) r = dist[i][j];
            }
        }
        return r;
    }
}
