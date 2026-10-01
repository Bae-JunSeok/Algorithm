import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1307 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        char ch = 'A';

        // 오른쪽 열부터 왼쪽 열로
        for (int j = n - 1; j >= 0; j--) {
            // 아래에서 위로
            for (int i = n - 1; i >= 0; i--) {
                arr[i][j] = ch;

                ch++;
                if (ch > 'Z') {
                    ch = 'A';
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}