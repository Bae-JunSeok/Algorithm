import java.util.ArrayList;

public class PG17684 {
    public static void main(String[] args) {
        PG17684 sol = new PG17684();
        System.out.println(sol.solution("KAKAO"));
    }

    public int[] solution(String msg){
        
        ArrayList<String> c = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        c.add("F");
        c.add("G");
        c.add("H");
        c.add("I");
        c.add("J");
        c.add("K");
        c.add("L");
        c.add("M");
        c.add("N");
        c.add("O");
        c.add("P");
        c.add("Q");
        c.add("R");
        c.add("S");
        c.add("T");
        c.add("U");
        c.add("V");
        c.add("W");
        c.add("X");
        c.add("Y");
        c.add("Z");

        int current = 0;

        while (current < msg.length()) {
            String s = "";
            int next = current;

            while(next < msg.length()){
                String sNext = s + msg.charAt(next);

                if(c.contains(sNext)){
                    s = sNext;
                    next++;
                } else {
                    break;
                }
            }

            result.add(c.indexOf(s));

            if(next < msg.length()){
                c.add(s + msg.charAt(next));
            }

            current = next;
        }
        

        
        for(int i = 0; i < result.size(); i++){
            result.set(i, result.get(i) + 1);
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }
}
