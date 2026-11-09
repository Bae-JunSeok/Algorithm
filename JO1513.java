import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1513 {
    static int n;
    static int[] arr;
    static int total = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        n = Integer.parseInt(br.readLine());

        arr = new int[2 * n - 1];

        dfs(0, 0, 0);

        sb.append("total ").append(total).append(" cases");
        System.out.println(sb);
    }

    static void dfs(int cnt, int win, int lose) {

        if (win == n) {
            for (int i = 0; i < cnt; i++) {
                if (arr[i] == 1) {
                    sb.append("o");
                } else {
                    sb.append("x");
                }
            }

            sb.append("\n");
            total++;
            return;
        }

        if (lose == n) {
            return;
        }

        arr[cnt] = 1;
        dfs(cnt + 1, win + 1, lose);

        arr[cnt] = 0;
        dfs(cnt + 1, win, lose + 1);
    }
}