import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO7028 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n % 2 == 0){
            System.out.println(n * n);
        } else {
            System.out.println(n * n + 1);
        }
    }
}
