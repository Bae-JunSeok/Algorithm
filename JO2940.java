import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO2940 {
    static int[] arr = new int[6];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 6; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
        }

        int second = 0;
        if(arr[4] > arr[5]){
            second = arr[4];
        } else {
            second = arr[5];
        }

        System.out.println(sum - min + second);
    }
}
