import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO8506 {
    static int[][] before;
    static int[][] after;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int n, m;
    static boolean result = true;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        before = new int[n][m];
        after = new int[n][m];
        isVisited = new boolean[n][m];
        int startX = 0, startY = 0, startValue = 0, newValue = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean found = false;

        outer:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(before[i][j] != after[i][j]){
                    startX = i;
                    startY = j;
                    startValue = before[i][j];
                    newValue = after[i][j];
                    found = true;
                    break outer;
                }
            }
        }
        if(found){
            bfs(startX, startY, startValue, newValue);
        }
        
        outer:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(before[i][j] != after[i][j]){
                    result = false;
                    break outer;
                } 
            }
        }

        if(result){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void bfs(int startX, int startY, int startValue, int newValue){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        before[startX][startY] = newValue;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || before[nx][ny] != startValue) continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
                before[nx][ny] = newValue;
            }
        }
    }
}
