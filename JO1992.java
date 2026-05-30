import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1992 {
    static int[] arr = new int[7];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 7; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tallest = 0;
        int secondTallest = 0;
        for(int i = 0; i < 7; i++){
            if(arr[i] > tallest){
                tallest = arr[i];
            }
        }
        for(int i = 0; i < 7; i++){
            if(arr[i] == tallest){
                arr[i] = -1;
                break;
            }
        }
        for(int i = 0; i < 7; i++){
            if(arr[i] > secondTallest){
                secondTallest = arr[i];
            }
        }


        System.out.println(tallest);
        System.out.println(secondTallest);
    }
}
