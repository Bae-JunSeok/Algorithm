import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += Integer.parseInt(br.readLine());
        }
        if(sum <= 21){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
