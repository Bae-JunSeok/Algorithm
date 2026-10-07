import java.io.*;
import java.util.*;

public class JO1002 {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long g = Long.parseLong(st.nextToken());
        long l = g;

        for (int i = 1; i < N; i++) {
            long num = Long.parseLong(st.nextToken());

            g = gcd(g, num);
            l = lcm(l, num);
        }

        System.out.println(g + " " + l);
    }
}