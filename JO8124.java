import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO8124 { 
    static int n, m;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static char[][] map;
    static boolean[][] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisited = new boolean[n][m];
        int result = 0;
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = input[j].charAt(0);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '#' && !isVisited[i][j]){
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == '.') continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
            }
        }
    }
}
