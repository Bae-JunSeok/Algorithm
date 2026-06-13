import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO2951 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = n + 1; i < n + 100; i++){
            if(i % 2 == 1){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
