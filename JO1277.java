import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JO1277 {
    static int n;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static char[][] result;
    static int startX, startY, endX, endY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        result = new char[n][n];
        
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j);
                result[i][j] = s.charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                } 

                if(map[i][j] == 'E'){
                    endX = i;
                    endY = j;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '.'){
                    isVisited = new boolean[n][n];
                    map[i][j] = '#';
                    boolean isOK = bfs(startX, startY);
                    if(!isOK){
                        result[i][j] = 'o';
                    }
                    map[i][j] = 'P';
                }
            }
        }   

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }


    static boolean bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            if(curX == endX && curY == endY) return true;
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == '#') continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return false;
    }
}
