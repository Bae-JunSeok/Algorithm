import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int win = Integer.parseInt(st.nextToken());
            int draw = Integer.parseInt(st.nextToken());
            int lose = Integer.parseInt(st.nextToken());

            int score = win * 3 + draw;

            maxScore = Math.max(maxScore, score);
        }

        System.out.println(maxScore);
    }
}