import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO5057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = "";
        s3 = s1 + s2;
        for(int i = s3.length() - 1; i > -1; i--){
            System.out.print(s3.charAt(i));
        }
    }
}
