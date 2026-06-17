import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1131 {
    static char[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static boolean[][] isVisited;
    static int n, m;
    static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = s[j].charAt(0);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (!isVisited[i][j] && map[i][j] == '*') {
                    int result = bfs(i, j);
                    if(result > Max) Max = result;
                }
            }
        }
        System.out.println(Max);
    }

    static int bfs(int startX, int startY){
        int count = 1;
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
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == '.') continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
                count++; 
            }
        }
        return count;
    }
}
