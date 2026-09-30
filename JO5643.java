import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JO5643 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("\\.");
        
        sb.append(input[0].charAt(2)).append(input[0].charAt(3));
        if(Integer.parseInt(input[1]) >= 10 && Integer.parseInt(input[1]) <= 12){
            sb.append(input[1]);
        } else {
            sb.append(0).append(input[1]);
        }

        if(input[2].length() < 2){
            sb.append(0).append(input[2]);
        } else {
            sb.append(input[2]);
        }

        sb.append("-XXXXXXX");
        
        System.out.print(sb);
    }
}
