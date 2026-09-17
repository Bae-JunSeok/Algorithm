import java.io.*;
import java.math.BigInteger;

public class JO1176 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());

        if (n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
            System.out.println("byte");
        } else if (n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
            System.out.println("short");
        } else if (n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
            System.out.println("int");
        } else if (n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            System.out.println("long");
        } else {
            System.out.println("BigInteger");
        }
    }
}