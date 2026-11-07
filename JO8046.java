import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8046 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\+");
        System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
    }
}
