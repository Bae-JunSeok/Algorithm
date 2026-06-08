import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0; i < 10; i++){
            System.out.print(s.charAt(0));
        }
    }
}
