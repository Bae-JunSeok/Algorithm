import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1457 {
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static ArrayList<Integer> result = new ArrayList<>();
    static int n, m, k;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int leftX, leftY, rightX, rightY;
            leftY = Integer.parseInt(st.nextToken());
            leftX = Integer.parseInt(st.nextToken());
            rightY = Integer.parseInt(st.nextToken());
            rightX = Integer.parseInt(st.nextToken());
            for(int j = leftX; j < rightX; j++){
                for(int p = leftY; p < rightY; p++){
                    map[j][p] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!isVisited[i][j] && map[i][j] != 1){
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

    static void bfs(int startX, int startY){
        int width = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        isVisited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            width++;
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == 1) continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
            }
        }

        result.add(width);

    }
}
