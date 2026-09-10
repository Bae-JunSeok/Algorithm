import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO11040 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int happyScore = 0;
        int sadScore = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;

            if(s.charAt(i) == 'H' || s.charAt(i) == 'A' || s.charAt(i) == 'P' || s.charAt(i) == 'Y'){
                happyScore++;
            }

            if(s.charAt(i) == 'S' || s.charAt(i) == 'A' || s.charAt(i) == 'D'){
                sadScore++;
            }
        }

        
        if(happyScore + sadScore == 0){ // 만약에 안나왔을 때
            System.out.printf("%.2f", 50.00);
        } else {
            double result = (double)happyScore / (happyScore + sadScore) * 100;
            result = Math.round(result * 100) / 100.0;
            System.out.printf("%.2f", result);
        }
    }
}
