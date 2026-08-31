import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG42586_1 {
    public static void main(String[] args)  {
        PG42586_1 sol = new PG42586_1();

        System.out.println(sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] days = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];

            int day = remain / speeds[i];

            if(remain % speeds[i] != 0){
                day++;
            }

            q.add(day);
        }

        while (!q.isEmpty()) {
            int first = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= first) {
                count++;
                q.poll();
            }

            result.add(count);
        }
        
        // for(int i = 0; i < result.size(); i++){
        //     System.out.println(result.get(i));
        // }


        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }


        return answer;
    }
}
