import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO3517 {
    static int n;
    static int[] arr;
    static int q;
    static int[] questions;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        q = Integer.parseInt(br.readLine());
        questions = new int[q];
        result = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++){
            questions[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < q; i++){
            result[i] = binarySearch(questions[i]);
        }

        for(int i = 0; i < q; i++){
            System.out.print(result[i] + " ");
        }
    }

    static int binarySearch(int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) return mid;

            if(target < arr[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
