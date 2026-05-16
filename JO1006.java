import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1006 {
    static int n, m;
    static int[][] map;
    static boolean[][][] isVisited;
    static int startX, startY, endX, endY;
    static int startD, endD;
    static int[] dx = new int[]{0, 0, 1, -1}; // 동서남북
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws Exception { // 방향도 카운트 해야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m][4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        startD = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1; 
        endD = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs());
    }


    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, startD, 0});
        isVisited[startX][startY][startD] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur_x = node[0];
            int cur_y = node[1];
            int cur_d = node[2];
            int cur_count = node[3];
            if(cur_x == endX && cur_y == endY && cur_d == endD) return cur_count;
            for(int i = 1; i <= 3; i++){
                int nx = cur_x + i * dx[cur_d];
                int ny = cur_y + i * dy[cur_d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isVisited[nx][ny][cur_d]) continue;
                if(map[nx][ny] == 1) break;
                q.add(new int[]{nx, ny, cur_d, cur_count + 1});
                isVisited[nx][ny][cur_d] = true;
            }
            int ld = 0; // 방향 왼쪽으로
            int rd = 0; // 방향 오른쪽으로
            if(cur_d == 3){
                ld = 1;
                rd = 0;
            } else if(cur_d == 1){
                ld = 2;
                rd = 3;
            } else if(cur_d == 2){
                ld = 0;
                rd = 1;
            } else if(cur_d == 0){
                ld = 3;
                rd = 2;
            }
            if (!isVisited[cur_x][cur_y][ld]) {
                isVisited[cur_x][cur_y][ld] = true;
                q.add(new int[]{cur_x, cur_y, ld, cur_count + 1});
            }

            if (!isVisited[cur_x][cur_y][rd]) {
                isVisited[cur_x][cur_y][rd] = true;
                q.add(new int[]{cur_x, cur_y, rd, cur_count + 1});
            }
        }
        return 0;
    }
}
