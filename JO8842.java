import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO8842 {

    static int N, K, Q;

    // 각 소의 현재 아름다움 값
    static int[][] cow;

    // map[i][j] =
    // (i,j)를 왼쪽 위로 하는 K x K 사진의 매력 지수
    static int[][] map;

    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Q = Integer.parseInt(br.readLine());

        cow = new int[N][N];
        map = new int[N - K + 1][N - K + 1];

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < Q; t++){

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            // 기존 값에서 얼마나 증가했는지
            int diff = z - cow[x][y];

            // 실제 소의 값 갱신
            cow[x][y] = z;

            // (x,y)를 포함할 수 있는 K x K 사진의
            // 왼쪽 위 좌표 범위
            int startX = Math.max(0, x - K + 1);
            int endX = Math.min(x, N - K);

            int startY = Math.max(0, y - K + 1);
            int endY = Math.min(y, N - K);

            // 영향을 받는 사진만 갱신
            for(int i = startX; i <= endX; i++){
                for(int j = startY; j <= endY; j++){

                    map[i][j] += diff;

                    // 전체를 다시 탐색하지 않고
                    // 바뀐 것만 max와 비교
                    max = Math.max(max, map[i][j]);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}