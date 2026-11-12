import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO2713 {
    static int m, n;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<int[]> secondQ = new LinkedList<>();
    // 일단 출발 위치에서 해가지고 상점까지 bfs를 돌리고 -> 상점에서 bfs를 한번 더 돌려
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int startX = 0;
        int startY = 0;
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }
        isVisited = new boolean[n][m];
        bfs(startX, startY);

        isVisited = new boolean[n][m];

        while (!secondQ.isEmpty()) {
            int[] node = secondQ.poll();
            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];
            if(map[curX][curY] == 3){
                System.out.println(curDist);
                return ;
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;
                isVisited[nx][ny] = true;
                secondQ.add(new int[]{nx, ny, curDist + 1});
            }
        }

        
    }

    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];
            if(map[curX][curY] == 4){
                secondQ.add(new int[]{curX, curY, curDist});
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == 1 || map[nx][ny] == 3) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny, curDist + 1});
            }
        }
    }
}
