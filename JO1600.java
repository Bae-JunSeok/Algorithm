import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1600 {
    static int n, m;
    static int[][] map;
    static int[][] mid;
    static boolean[][] isVisited;
    static int result;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        mid = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mid[i][j] = map[i][j];
            }
        }

        while (true) {
            // 여기서 일단 시뮬레이션으로 빙산 녹이고 나서 bfs를 돌려가지고 갯수 확인
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int c = 0;
                    if(map[i][j] != 0){
                        for(int dir = 0; dir < 4; dir++){
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(map[nx][ny] == 0) c++;
                        }
                        mid[i][j] = Math.max(0, mid[i][j] - c);
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    map[i][j] = mid[i][j];
                }
            }

            result++;
            isVisited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!isVisited[i][j] && map[i][j] != 0){
                        bfs(i, j);
                        count++;
                    }
                }
            }
            
            if(count >= 2){
                System.out.println(result);
                return;
            }

            if(count == 0){
                System.out.println(0);
                return;
            }
        }
    }


    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
