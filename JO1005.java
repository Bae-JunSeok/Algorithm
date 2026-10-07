import java.io.*;
import java.util.*;

public class JO1005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int maxPrimeFactor = -1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            int primeFactor = getMaxPrimeFactor(num);

            // 같은 경우에는 먼저 입력된 숫자를 유지
            if (primeFactor > maxPrimeFactor) {
                maxPrimeFactor = primeFactor;
                answer = num;
            }
        }

        System.out.println(answer);
    }

    static int getMaxPrimeFactor(int num) {
        if (num == 1) {
            return 1;
        }

        int maxFactor = 1;
        int temp = num;

        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                maxFactor = i;
                temp /= i;
            }
        }

        // 마지막에 남은 수가 1보다 크다면 소수
        if (temp > 1) {
            maxFactor = temp;
        }

        return maxFactor;
    }
}