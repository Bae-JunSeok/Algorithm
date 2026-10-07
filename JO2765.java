import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JO2765 {
    static char[][] map;
    static boolean[][] isVisitedA;
    static boolean[][] isVisitedB;
    static int n;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int resultA, resultB;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        isVisitedA = new boolean[n][n];
        isVisitedB = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisitedA[i][j]){
                    resultA++;
                    bfsNormal(i, j, map[i][j]);
                } 
                if(!isVisitedB[i][j]){
                    resultB++;
                    bfsNotNormal(i, j, map[i][j]);
                }
            }
        }


        System.out.println(resultA + " " + resultB);
    }

    static void bfsNormal(int startX, int startY, char c){
        Queue<int[]> q= new LinkedList<>();
        isVisitedA[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(map[nx][ny] != c) continue;
                if(isVisitedA[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                isVisitedA[nx][ny] = true;
            }
        }
    }


    static void bfsNotNormal(int startX, int startY, char c){
        Queue<int[]> q= new LinkedList<>();
        isVisitedB[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(isVisitedB[nx][ny]) continue;
                if(c == 'R' || c == 'G'){
                    if(map[nx][ny] == 'R' || map[nx][ny] == 'G'){
                        q.add(new int[]{nx, ny});
                        isVisitedB[nx][ny] = true;
                    } else {
                        continue;
                    }
                } else {
                    if(map[nx][ny] != c) continue;
                    q.add(new int[]{nx, ny});
                    isVisitedB[nx][ny] = true;
                }
            }
        }
    }
}
