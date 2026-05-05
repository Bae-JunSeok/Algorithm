import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1078 {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];
        dist = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;
        bfs(startX, startY);
        int Max = Integer.MIN_VALUE;
        int zergling = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dist[i][j] > Max) Max = dist[i][j];
                if(!isVisited[i][j] && map[i][j] == 1) zergling++;
            }
        }
        sb.append(Max + 3).append("\n").append(zergling);
        System.out.println(sb);
    }

    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur_x = node[0];
            int cur_y = node[1];
            
            for(int dir = 0; dir < 4; dir++){
                int nx = cur_x + dx[dir];
                int ny = cur_y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny] || map[nx][ny] == 0) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                dist[nx][ny] = dist[cur_x][cur_y] + 1;
            }
        }
    }
}
