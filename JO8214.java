import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO8214 {
    static int m, n;
    static int startX, startY;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, -1, 0, 1, -1, 1, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken()) - 1;
        startX = n - Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = input[j].charAt(0);
            }
        }
        map[startX][startY] = 'M';
        boolean isCoveredBeforeBfs = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.') {
                    isCoveredBeforeBfs = false;
                }
            }
        }
        if(isCoveredBeforeBfs){
            System.out.println(0);
        } else {
            System.out.println(bfs(startX, startY));
        }
        
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY, 1});
        int dotCount = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curCount = node[2];
            for(int dir = 0; dir < 8; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == '*') continue;
                q.add(new int[]{nx, ny, curCount + 1});
                isVisited[nx][ny] = true;
                map[nx][ny] = 'M';
            }
            dotCount = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == '.') {
                        dotCount++;
                    }
                }
            }
            if(dotCount == 0){
                return curCount;
            }
        }


        return 0;
    }
}
