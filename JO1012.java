import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String team = st.nextToken();
            int point = Integer.parseInt(st.nextToken());

            sum += point;
        }

        int draw = 3 * N - sum;

        System.out.println(draw);
    }
}