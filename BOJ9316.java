import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9316 {
    public static void main(String[] args) throws Exception {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            System.out.println("Hello World, Judge " + (i + 1) + "!");
        }
    }
}
