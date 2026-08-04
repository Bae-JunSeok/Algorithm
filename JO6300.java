import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO6300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        System.out.println(a * b + c);
    }
}
