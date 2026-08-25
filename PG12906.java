import java.util.ArrayList;

public class PG12906 {
    public static void main(String[] args) {
        PG12906 sol = new PG12906();

        System.out.println(sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
    }

    public int[] solution(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        int previous = arr[0];
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(previous == arr[i]) {
                continue;
            } else {
                previous = arr[i];
                result.add(arr[i]);
            }
        }

        int[] real_result = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            real_result[i] = result.get(i);
        }

        return real_result;
    }
}
