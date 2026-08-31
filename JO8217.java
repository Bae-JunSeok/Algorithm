import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int b = a / 2;

        int c = a % 2;

        System.out.println(3 * b - 2 * b + 3 * c);
    }
}
