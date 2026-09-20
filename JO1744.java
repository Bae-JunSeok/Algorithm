import java.io.*;
import java.util.*;

public class JO1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int zeroCount = 0;

            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount == 0) {
                System.out.println("E"); // 모
            } else if (zeroCount == 1) {
                System.out.println("A"); // 도
            } else if (zeroCount == 2) {
                System.out.println("B"); // 개
            } else if (zeroCount == 3) {
                System.out.println("C"); // 걸
            } else {
                System.out.println("D"); // 윷
            }
        }
    }
}