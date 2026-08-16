import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8216 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int money = n * 100;

        System.out.println(money / 500);
    }
}
