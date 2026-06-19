import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO2440 {
    static int[] dp = new int[50001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        dp[3] = 1;
        dp[5] = 1;
        for(int i = 6; i <= 50000; i++){
            int resultAboutThree = 0;
            int resultAboutFive = 0;
            resultAboutThree = i - 3;
            resultAboutFive = i - 5;
            if(dp[resultAboutThree] == -1 && dp[resultAboutFive] == -1) { // 둘 다 -1일 때
                continue;
            } else if(dp[resultAboutFive] != -1 && dp[resultAboutThree] == -1){
                dp[i] = dp[resultAboutFive] + 1;
            } else if(dp[resultAboutFive] == -1 && dp[resultAboutThree] != -1){
                dp[i] = dp[resultAboutThree] + 1;
            } else if(dp[resultAboutFive] != -1 && dp[resultAboutThree] != -1){
                dp[i] = Math.min(dp[resultAboutFive] + 1, dp[resultAboutThree] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
