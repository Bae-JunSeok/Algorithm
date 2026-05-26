import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO1018 {
    static int[] arr = new int[4]; // 입력을 담기 위한
    static ArrayList<Integer> arrayList = new ArrayList<>(); // 시계수들의 집합을 담기 위한 arraylist
    static int min = Integer.MAX_VALUE;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < 4; i++){
            int a = 0;
            a += 1000 * arr[i % 4];
            a += 100 * arr[(i + 1) % 4];
            a += 10 * arr[(i + 2) % 4];
            a += arr[(i + 3) % 4];
            if(a < min){
                min = a;
            }
            
        }
        for(int i = 1111; i <= 9999; i++){
            int Min = Integer.MAX_VALUE;
            int[] arr1 = new int[4];
            arr1[0] = i / 1000;
            arr1[1] = i % 1000 / 100;
            arr1[2] = i % 100 / 10;
            arr1[3] = i % 10;
            if(arr1[0] == 0 || arr1[1] == 0 || arr1[2] == 0 || arr1[3] == 0) continue;
            for(int j = 0; j < 4; j++){
                int a = 0;
                a += 1000 * arr1[j % 4];
                a += 100 * arr1[(j + 1) % 4];
                a += 10 * arr1[(j + 2) % 4];
                a += arr1[(j + 3) % 4];
                if(a < Min){
                    Min = a;
                }
            }
            if(!arrayList.contains(Min)){
                arrayList.add(Min);
            }
        }
        
        for(int i = 0; i < arrayList.size(); i++){
            if(min == arrayList.get(i)){
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
