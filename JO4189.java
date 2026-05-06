import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO4189 {
    static int n, m;
    //static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -2, -1};
    static int endX, endY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        //map = new int[n][m];
        isVisited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;
        int result = bfs(startX, startY);
        System.out.println(result);
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        isVisited[startX][startY] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];
            if(curX == endX && curY == endY) return curDist;
            for(int dir = 0; dir < 8; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny]) continue;
                q.add(new int[]{nx, ny, curDist + 1});
                isVisited[nx][ny] = true;
            }
        }
        return 0;
    }
}
