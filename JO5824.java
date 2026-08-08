import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5824 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n * 24);
    }
}
