import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO19183 {
    static int n, c, k;
    static int[] people;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        people = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        int p = 0;
        while (true) {
            int sum = 0;
            if(p >= n) break;
            if(people[p] > k){
                result = -1;
                break;
            }
            int end = Math.min(n, p + c);  // 여기서 고정

            for (int i = p; i < end; i++) {
            if (sum + people[i] > k) {
                break;
            }

            sum += people[i];
            p++;
            }
            result++;
        }

        System.out.println(result);
    }
}
