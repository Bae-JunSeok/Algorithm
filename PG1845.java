import java.util.ArrayList;

public class PG1845 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        PG1845 sol = new PG1845();

        System.out.println(sol.solution(new int[]{1, 2, 3, 4}));
    }

    public String solution(int[] nums){
        int canPick = nums.length / 2;
        for(int i = 0; i < nums.length; i++){
            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
            }
        }

        int result = Math.min(canPick, arr.size());
        
        String answer = "" + result;

        return answer;
    }
}
