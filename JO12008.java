import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO12008 {
    static int n, m;
    static char[][] map;
    static boolean[][] isVisited;
    static int startX, startY, endX, endY;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                if(map[i][j] == 'G'){
                    endX = i;
                    endY = j;
                }
            }
        }
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
            int curDist = node[2];
            if(curX == endX && curY == endY) return curDist;
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == '#') continue;
                q.add(new int[]{nx, ny, curDist + 1});
                isVisited[nx][ny] = true;
            }
        }
        return 0;
    }
}
