import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1071 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < n; i++){
            if(m % arr[i] == 0){
                result1 += arr[i];
            }
            if(arr[i] % m == 0){
                result2 += arr[i];
            }
        }

        System.out.println(result1);
        System.out.println(result2);
    }
}
