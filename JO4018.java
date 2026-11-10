import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO4018 {
    static int n; // 맵의 크기
    static int k; // 길의 정보
    static int r; // 소의 정보
    static int result;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static ArrayList<int[]> cows = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[2 * n][2 * n];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int aX = Integer.parseInt(st.nextToken()) * 2 - 1;
            int aY = Integer.parseInt(st.nextToken()) * 2 - 1;
            int bX = Integer.parseInt(st.nextToken()) * 2 - 1;
            int bY = Integer.parseInt(st.nextToken()) * 2 - 1;
            if(aX - bX == 0){
                map[Math.min(aX, bX)][Math.min(aY, bY) + 1] = 1;
            } else {
                map[Math.min(aX, bX) + 1][Math.min(aY, bY)] = 1;
            }
        }

        for(int i = 0; i < k; i++){ // 소 정보를 map과 cows에 저장
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) * 2 - 1;
            int y = Integer.parseInt(st.nextToken()) * 2 - 1;
            map[x][y] = 2; // 소는 2로 표현
            cows.add(new int[]{x, y});
        }

        isVisited = new boolean[2 * n][2 * n];
        for(int i = 0; i < cows.size(); i++){
            int startX = cows.get(i)[0];
            int startY = cows.get(i)[1];
            if(isVisited[startX][startY]) continue;
            int count = bfs(startX, startY);

            result += count * (k - count);
        }


        System.out.println(result / 2);
    }

    static int bfs(int startX, int startY){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        isVisited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            if(map[curX][curY] == 2) count++;
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 1 || nx >= 2 * n || ny < 1 || ny >= 2 * n) continue;
                if(map[nx][ny] == 1) continue;
                if(isVisited[nx][ny]) continue;
                if(nx % 2 == 0 && ny % 2 == 0) continue;
                q.add(new int[]{nx, ny});
                isVisited[nx][ny] = true;
            }
        }

        return count;
    }
}
