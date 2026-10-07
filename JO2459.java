import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int cal = 0;
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            cal += in;
            cal -= out;
            result = Math.max(cal, result);
        }
        
        System.out.println(result);
    }
}
