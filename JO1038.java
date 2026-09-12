import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JO1038 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        char op = br.readLine().charAt(0);
        BigInteger b = new BigInteger(br.readLine());

        BigInteger result;

        if (op == '+') {
            result = a.add(b);
        } else {
            result = a.multiply(b);
        }

        System.out.println(result);
    }
}
