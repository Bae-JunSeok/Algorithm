import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO5461 {
    static long min = Long.MAX_VALUE;
    static long Max = Long.MIN_VALUE;
    static int n, m;
    static long[] arr;
    static long target;
    static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        long left = 0, right = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
            left = Long.max(left, arr[i]);
            right += arr[i];
        }

        while (left <= right) {
            long target = (right + left) / 2;

            long sum = 0;
            int count = 1;
            for(int i = 0; i < n; i++){
                if(sum + arr[i] > target){
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if(count > m){
                left = target + 1;
            } else {
                result = target;
                right = target - 1;
            }
        }
        
        
        System.out.println(result);

    }
}
