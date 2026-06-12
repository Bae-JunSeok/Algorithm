import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JO1128 {
    static ArrayList<Integer> arr;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int Max = Integer.MIN_VALUE;
        int a = n - 1;
        for(int i = a; i > 0; i--){
            arr = new ArrayList<>();
            arr.add(n);
            arr.add(i);
            while (true) {
                int b = arr.get(arr.size() - 2) - arr.get(arr.size() - 1);
                if(b < 0) break;
                arr.add(b);
            }
            if(arr.size() > Max){
                result = arr;
                Max = arr.size();
            }
        }

        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
