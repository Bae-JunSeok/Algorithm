import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        System.out.println(a * a * a);
    }
}
