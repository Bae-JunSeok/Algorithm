import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JO1599 {
    static ArrayList<int[]> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 6; i++){
            int b = target - i;
            if(b <= 6 && b >= 1){
                result.add(new int[]{i, b});
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }
    }
}
