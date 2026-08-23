import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO8088 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        int Max = -1000;
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > Max){
                Max = arr[i];
            }
        }

        System.out.println(Max);
    }
}
