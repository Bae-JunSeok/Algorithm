import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO1008_1 {
    static int n, t;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

     static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    startX = i;
                    startY = j;
                }
                if(map[i][j] == -2){
                    endX = i;
                    endY = j;
                }
            }
        }

        int answer = solve(startX, startY, endX, endY);

        System.out.println(answer);
    }

    static int solve(int startX, int startY, int endX, int endY){
        int[][] cur = new int[n][n];
        int[][] next = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(cur[i], INF);
            Arrays.fill(next[i], INF);
        }

        cur[startX][startY] = 0;

        int answer = INF;

        if(startX == endX && startY == endY) answer = 0;

        for(int time = 1; time <= t; time++){
            for(int i = 0; i < n; i++){
                Arrays.fill(next[i], INF);
            }

            
        }
    }
}
