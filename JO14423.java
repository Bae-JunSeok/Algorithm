import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO14423 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if(a - b == 0) {
            System.out.println("He is a real alpaca");
        } else if(Math.abs(a - b) <= 3){
            System.out.println("He is similar alpaca");
        } else {
            System.out.println("He is a fake alpaca");
        }
    }
}
