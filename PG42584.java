import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG42584 {
    public static void main(String[] args) {
        PG42584 sol = new PG42584();

        System.out.println(sol.solution(new int[]{1, 2, 3, 2, 3}));
    }

    public int[] solution(int[] prices){

        int[] answer = new int[prices.length];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < prices.length; i++){
            q.add(new int[]{prices[i], i});
        }

        ArrayList<Integer> results = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curValue = node[0];
            int curX = node[1];

            int result = 0;

            if(curX == prices.length - 1){ // 마지막이면 걍 0 넣어
                results.add(0);
                break;
            }

            for(int i = curX + 1; i < prices.length; i++){
                if(curValue <= prices[i]){
                    result++;
                } else if(curValue > prices[i]){
                    result++;
                    results.add(result);
                    break;
                }

                if(i == prices.length - 1){
                    results.add(result);
                }

            }
        }

        for(int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }

        return answer;
    }
}
