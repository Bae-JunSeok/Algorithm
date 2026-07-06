import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1840 {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int now = 0, future = 1000000000;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) now++; // 맨 처음의 치즈 갯수 세기
            }
        }
        
        while (future != 0) {
            future = 0;
            isVisited = new boolean[n][m];
            bfs(0, 0);

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1){ // bfs 한 번 돌고나서 치즈 갯수 세기
                        future++;
                    }
                }
            }
            if(future != 0){
                now = future;
            }
            time++;
        }

        System.out.println(time);
        System.out.println(now);
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
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    isVisited[nx][ny] = true;
                    continue;
                }
                if(map[nx][ny] == 0){
                    q.add(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                }
            }
        }
    }
}