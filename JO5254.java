import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO5254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                for(int j = 0; j < m; j++){
                    sb.append("*");
                }
            } else {
                sb.append("*");
                for(int j = 1; j < m - 1; j++){
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
