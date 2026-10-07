import java.util.LinkedList;
import java.util.Queue;

public class PG42587 {
    public static void main(String[] args) {
        PG42587 sol = new PG42587();

        System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location){
        int answer = 1;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }

        while (!q.isEmpty()) {
            int Max = Integer.MIN_VALUE;
            int index = -1;
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] > Max) {
                    Max = priorities[i];
                    index = i;
                }
            }

            int[] node = q.poll();
            int curX = node[0];
            int curPriority = node[1];

            if(curPriority == Max){
                if(curX == location){
                    return answer;
                } 
                priorities[index] = -1;
                answer++;
            } else {
                q.add(new int[]{curX, curPriority});
            }
        }

        return answer;
    }
}
