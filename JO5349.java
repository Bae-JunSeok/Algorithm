import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO5349 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < s.length; i++){
            if(i % 2 == 1){
                arr.add(s[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size() - 1; i > -1; i--){
            sb.append(arr.get(i)).append(" ");
        }
        
        System.out.println(sb);

    }
}
