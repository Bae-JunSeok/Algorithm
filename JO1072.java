import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO1072 {
    static int[] arr;
    static int n, m;
    //static ArrayList<Integer> result = new ArrayList<>();
    static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += arr[i];
        }

        Max = sum;

        for(int i = 0; i < n - m; i++){
            sum -= arr[i];
            sum += arr[i + m];
            if(sum > Max) Max = sum;
        }

        System.out.println(Max);
    }
}
