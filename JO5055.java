import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5055 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0; i < 2; i++){
            System.out.print(s.charAt(s.length() - 1));
        }
    }
}
