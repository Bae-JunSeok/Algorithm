import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 1;
        StringBuilder sb = new StringBuilder();
        while (n >= a) {
            for(int i = a; i < a + 20; i++){
                sb.append(i);
            }
            sb.append("\n");
            a++;
        }
        System.out.println(sb);
    }
}
