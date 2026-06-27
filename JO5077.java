import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5077 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.contains("a") || s.contains("A")){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
