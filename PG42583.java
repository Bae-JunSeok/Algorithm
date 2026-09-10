import java.util.LinkedList;
import java.util.Queue;

public class PG42583 {
    public static void main(String[] args) {
        PG42583 sol = new PG42583();

        System.out.println(sol.solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weight){
        int answer = 0; // 결과 즉 몇 초가 걸리는지
        int sum = 0; // 무게를 더하는 거
        int index = 0;

        Queue<int[]> q = new LinkedList<>();

        while (index < truck_weight.length || !q.isEmpty()) {
            answer++;

            if(!q.isEmpty()){
                int[] front = q.peek();

                if(answer - front[1] >= bridge_length){
                    sum -= front[0];
                    q.poll();
                }
            }

            if(index < truck_weight.length && sum + truck_weight[index] <= weight){

                sum += truck_weight[index];
                q.add(new int[]{truck_weight[index], answer});
                index++;
            }

        }

        return answer;
    }
}
