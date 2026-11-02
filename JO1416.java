import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1416 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        int sum = 0;
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] < 40){
                System.out.println("불합격");
                return;
            }
            sum += arr[i];
        }

        sum /= 3;
        if(sum >= 60){
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
    }
}
