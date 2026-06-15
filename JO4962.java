import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO4962 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 5; j++){
                sb.append(i);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
