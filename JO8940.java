import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        double result = a * b;
        result = Math.round(result);
        
        sb.append(s).append(":").append((int)result);


        System.out.println(sb);
    }
}
