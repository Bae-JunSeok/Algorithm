import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8028 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++){
            if(br.readLine().equals("merci")) count++;
        }

        System.out.println(count);
    }
}
