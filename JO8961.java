import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8961 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int result = a * 1 + 300 * b;
        System.out.println(result);
    }
}
