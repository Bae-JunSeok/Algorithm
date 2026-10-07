import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1748 {
    static int[][] map;
    static int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            map = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i == j) continue;
                    map[i][j] = INF;
                }
            }
            for(int i = 1; i <= n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                for(int j = 0; j < a; j++){
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    map[i][b] = c;
                }
            }

            for(int k = 1; k <= n; k++){
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= n; j++){
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int answerPerson = -1;
            int answerTime = INF;

            // 각 사람을 시작점으로 했을 때
            for (int i = 1; i <= n; i++) {

                int maxTime = 0;
                boolean possible = true;

                for (int j = 1; j <= n; j++) {

                    // i에서 j로 갈 수 없음
                    if (map[i][j] == INF) {
                        possible = false;
                        break;
                    }

                    maxTime = Math.max(maxTime, map[i][j]);
                }

                // 모든 사람에게 전달 가능하고
                // 현재까지 가장 빠른 경우
                if (possible && maxTime < answerTime) {
                    answerTime = maxTime;
                    answerPerson = i;
                }
            }

            if (answerPerson == -1) {
                System.out.println("disjoint");
            } else {
                System.out.println(answerPerson + " " + answerTime);
            }
        }

    }
}
