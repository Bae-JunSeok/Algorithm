import java.util.ArrayList;

public class PG42586 {
    public static void main(String[] args) {
        PG42586 sol = new PG42586();

        System.out.println(sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> result = new ArrayList<>();

        int index = 0;

        while (true) {
            if(index == progresses.length) break;

            int count = 0;
            for(int i = index; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }

            if(progresses[index] >= 100){
                for(int j = index; j < progresses.length; j++){
                    if(progresses[j] >= 100){
                        count++;
                        index++;
                    } else {
                        break;
                    }
                }
            }

            if(count != 0){
                result.add(count);
            }
        }

        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
