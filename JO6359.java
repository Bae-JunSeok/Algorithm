import java.io.*;
import java.util.*;

public class JO6359 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            sb.append(count(M) - count(N - 1)).append('\n');
        }

        System.out.print(sb);
    }

    static long count(long x) {
        if (x <= 0) return 0;

        char[] s = Long.toString(x).toCharArray();
        int len = s.length;

        long result = 0;

        // x보다 자릿수가 작은 수들
        for (int l = 1; l < len && l <= 10; l++) {
            long cnt = 9;

            for (int j = 1; j < l; j++) {
                cnt *= (10 - j);
            }

            result += cnt;
        }

        // 10자리를 넘어가면 더 이상 중복 없는 수가 존재하지 않음
        if (len > 10) {
            return result;
        }

        boolean[] used = new boolean[10];

        for (int i = 0; i < len; i++) {
            int cur = s[i] - '0';

            int start = (i == 0) ? 1 : 0;

            for (int d = start; d < cur; d++) {
                if (used[d]) continue;

                int remain = len - i - 1;

                long ways = 1;
                int available = 10 - (i + 1);

                for (int k = 0; k < remain; k++) {
                    ways *= (available - k);
                }

                result += ways;
            }

            if (used[cur]) {
                return result;
            }

            used[cur] = true;
        }

        // x 자체도 중복이 없다면 포함
        return result + 1;
    }
}