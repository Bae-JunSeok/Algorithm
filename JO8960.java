import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO8960 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int a = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(arr.get(i) == arr.get(j)){
                    a += Math.abs(j - i);
                }
            }
            result.add(a);
        }
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
