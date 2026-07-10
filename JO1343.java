import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long preliminaryRate = Long.parseLong(br.readLine());
        long finalRate = Long.parseLong(br.readLine());
        long nationalParticipants = Long.parseLong(br.readLine());

        long result = nationalParticipants * 10000
                / (preliminaryRate * finalRate);

        System.out.println(result);
    }
}