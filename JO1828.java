import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO1828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
        }

        arr.sort(Comparator.comparingInt(a -> a[1]));

        int result = 0;
        int fridgeTemp = -1000000000;

        for(int[] cur : arr){
            int low = cur[0];
            int high = cur[1];

            // 현재 냉장고 온도가 이 물질의 범위에 안 들어가면 새 냉장고 필요
            if(fridgeTemp < low){
                result++;
                fridgeTemp = high;
            }
        }

        System.out.println(result);
    }
}
