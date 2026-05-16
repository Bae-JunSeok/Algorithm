import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO4964 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = i; j < i + 4; j++){
                sb.append(j);
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
