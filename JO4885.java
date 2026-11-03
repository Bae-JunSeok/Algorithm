import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO4885 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int[] arr = new int[s.length];
        for(int i = 0; i < s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        for(int i = 0; i < s.length; i++){
            System.out.print(arr[i]);
        }
    }
}
