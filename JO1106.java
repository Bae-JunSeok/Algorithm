import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1106 {
    static int n, m;
    static int startX, startY, endX, endY;
    static int[] dx = new int[]{-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] dy = new int[]{-1, -2, 1, 2, 1, 2, -1, -2};
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs(startX, startY));
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY, 0});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curCount = node[2];
            if(curX == endX && curY == endY) return curCount;
            for(int dir = 0; dir < 8; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny]) continue;
                q.add(new int[]{nx, ny, curCount + 1});
                isVisited[nx][ny] = true;
            }
        }

        return -1;
    }
}
