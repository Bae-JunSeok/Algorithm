import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO6183 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = n; i > 0; i--){
            for(int j = i + n - 1; j >= 1; j--){
                sb.append("i" + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
