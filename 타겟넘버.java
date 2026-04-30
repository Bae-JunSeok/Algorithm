import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] number = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        타겟넘버 sol = new 타겟넘버();

        int answer = sol.solution(number, target);

        System.out.println(answer);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        // 제일 작게 나올 수 있는 값이랑, 제일 크게 나올 수 있는 값으로 범위를 제한
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        boolean[] isVisited = new boolean[2 * sum + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(numbers[0]);
        q.add(numbers[1] * (-1));
        isVisited[numbers[0] + sum] = true;
        isVisited[numbers[0] * (-1) + sum] = true;
        while (!q.isEmpty()) {
            
        }

        return answer;
    }
}
