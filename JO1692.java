import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1692 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int b100 = b / 100;
        int b10 = b % 100 / 10;
        int b1 = b % 10;

        sb.append(a * b1).append("\n").append(a * b10).append("\n").append(a * b100).append("\n").append(a * b);

        System.out.println(sb);
    }
}
