import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO8963 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(st.nextToken()) >= x){
                result++;
            }
        }
        System.out.println(result);
    }
}
