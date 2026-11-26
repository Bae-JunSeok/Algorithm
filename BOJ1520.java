import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ1520 {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y){

        // 목적지에 도착한 경우
        if(x == n - 1 && y == m - 1){
            return 1;
        }

        // 이미 탐색한 좌표인 경우
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        // 최초 탐색 시 경로 개수를 0으로 초기화
        dp[x][y] = 0;

        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(map[nx][ny] >= map[x][y]) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
}