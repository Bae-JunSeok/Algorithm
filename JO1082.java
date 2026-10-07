import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1082 {
    static int n, m;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static char[][] map;
    static int manX, manY;
    static int targetX, targetY;
    static ArrayList<int[]> fire = new ArrayList<>();
    static int[][] k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'D'){
                    targetX = i;
                    targetY = j;
                } else if(map[i][j] == 'S'){
                    manX = i;
                    manY = j;
                } else if(map[i][j] == '*'){
                    fire.add(new int[]{i, j});
                }
            }
        }

        fireBFS();
        int result = manBFS(manX, manY);
        if(result == -1){
            System.out.println("impossible");
        } else {
            System.out.println(result);
        }



    }

    static int manBFS(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        int[][] p = new int[n][m];

        q.add(new int[]{startX, startY});
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            if(curX == targetX && curY == targetY) return p[curX][curY]; 
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;   
                if(map[nx][ny] == 'X' || p[nx][ny] != 0) continue;
                int nextT = p[curX][curY] + 1;
                if(nextT >= k[nx][ny] && k[nx][ny] != -1) continue;
                q.add(new int[]{nx, ny});
                p[nx][ny] = p[curX][curY] + 1;
            }
        }
        
        return -1;
    }

    static void fireBFS(){
        Queue<int[]> q = new LinkedList<>();
        k = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(k[i], -1);
        }


        for(int i = 0; i < fire.size(); i++){
            q.add(new int[]{fire.get(i)[0], fire.get(i)[1]});
            k[fire.get(i)[0]][fire.get(i)[1]] = 0;
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 'X' || k[nx][ny] != -1 || map[nx][ny] == 'D') continue;
                k[nx][ny] = k[curX][curY] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
