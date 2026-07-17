import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class JO1695 {
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static boolean[][] isVisited;
    static int n;
    static int result;
    static ArrayList<Integer> aparts = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];
        for(int i = 0; i < n; i++){ // 입력
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !isVisited[i][j]){
                    aparts.add(bfs(i, j));
                    result++;
                }
            }
        }

        System.out.println(result);
        Collections.sort(aparts);
        for(int i = 0; i < aparts.size(); i++){
            System.out.println(aparts.get(i));
        }
    }

    static int bfs(int startX, int startY){
        int a = 1;
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
                if(isVisited[nx][ny] || map[nx][ny] == 0) continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
                a++;
            }
        }
        return a;
    }
}
