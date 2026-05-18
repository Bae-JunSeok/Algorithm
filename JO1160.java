import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1160 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        for(int i = 0; i < 12; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            result += a;
        }
        result = result / 12;
        System.out.println(Math.round(result * 100) / 100.0);
    }
}
