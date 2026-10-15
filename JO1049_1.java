import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1049_1 {
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] result;
    static ArrayList<int[]> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) arr.add(new int[]{i, j});
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < arr.size(); i++){
            int x = arr.get(i)[0];
            int y = arr.get(i)[1];
            result[x][y] = bfs(x, y);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        isVisited = new boolean[n][n];
        isVisited[startX][startY] = true;
        int minDist = -1;
        int value = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];

            if(minDist != -1 && curDist > minDist){
                break;
            } 

            if(map[curX][curY] != 0){
                if(minDist == -1){
                    minDist = curDist;
                    value = map[curX][curY];
                }

                count++;
                continue;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                //int nextDist = Math.abs(startX - nx) + Math.abs(startY - ny);
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(isVisited[nx][ny]) continue;
                q.add(new int[]{nx, ny, curDist + 1});
                isVisited[nx][ny] = true;
            }
        }

        if(count == 1){
            return value;
        }

        return 0;
    }
}
