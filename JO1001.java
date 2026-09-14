import java.io.*;
import java.util.*;

public class JO1001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int legs = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (n == 0 && legs == 0) {
                break;
            }

            // 입력 범위 검사
            if (n < 0 || n > 1000 || legs < 0 || legs > 4000) {
                sb.append("INPUT ERROR!\n");
                continue;
            }

            // 강아지 4개, 병아리 2개
            // dog + chick = n
            // 4dog + 2chick = legs
            // => dog = (legs - 2n) / 2

            int diff = legs - 2 * n;

            if (diff < 0 || diff % 2 != 0) {
                sb.append("0\n");
                continue;
            }

            int dog = diff / 2;
            int chick = n - dog;

            if (dog < 0 || chick < 0) {
                sb.append("0\n");
            } else {
                sb.append(dog).append(" ").append(chick).append("\n");
            }
        }

        System.out.print(sb);
    }
}
