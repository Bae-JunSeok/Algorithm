import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO4963 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(i + 1).append(i + 2).append("\n");
        }
        System.out.println(sb);
    }
}
