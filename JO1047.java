import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1047 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }

    static int fibo(int n){
        if(n == 1){
            return 1;
        } else if(n == 2){
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}