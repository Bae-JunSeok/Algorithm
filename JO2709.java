import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO2709 {
    static int[][] arr = new int[2][4];
    static int[] sum = new int[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.fill(sum, 0);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                sum[i] += arr[i][j];
            }
        }
        if(sum[0] >= sum[1]){
            System.out.println(sum[0]);
        } else {
            System.out.println(sum[1]);
        }
    }
}
