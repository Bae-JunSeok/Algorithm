import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1096 {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = new int[]{0, -1, 0, 1, 1, -1, 1, -1};
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!isVisited[i][j] && map[i][j] != 0){
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(result);
    }

    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        boolean isTop = true;
        while (!q.isEmpty()) {
            
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 8; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[curX][curY] < map[nx][ny]){
                    isTop = false;
                } else if(map[curX][curY] == map[nx][ny] && !isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } 
            }

        }

        if(isTop) result++;
    }
}
