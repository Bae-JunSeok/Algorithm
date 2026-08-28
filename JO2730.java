import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO2730 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int b = a / 2;
        System.out.println(4 * b + (b + a % 2) * 5);
    }
}
