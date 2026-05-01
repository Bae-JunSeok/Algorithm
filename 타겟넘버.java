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
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, numbers[0]});
        q.add(new int[]{0, numbers[0] * (-1)});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            
            int index = node[0];
            int sum = node[1];

            if(index == numbers.length - 1){
                if(sum == target)
                {
                    answer++;
                }
                continue;  
            }
            int nextIndex = index + 1;

            q.add(new int[]{nextIndex, sum + numbers[nextIndex]});
            q.add(new int[]{nextIndex, sum - numbers[nextIndex]});
        }

        return answer;
    }
}
