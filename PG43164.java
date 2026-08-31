import java.util.ArrayList;

public class PG43164 {
    public static void main(String[] args) {
        PG43164 sol = new PG43164();

        System.out.println(sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    }

    public String[] solution(String[][] tickets){
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        int n = 0;

        for(int i = 0; i < tickets.length; i++){
            for(int j = 0; j < 2; j++){
                if(!name.contains(tickets[i][j])){
                    name.add(tickets[i][j]);
                    num.add(n++);
                }
            }
        }

        ArrayList<Integer>[] arr = new ArrayList[name.size()];
        for(int i = 0; i < name.size(); i++){
            arr[i] = new ArrayList<>();
        }

        boolean[] isVisited = new boolean[name.size()];

        for(int i = 0; i < tickets.length; i++){
            for(int j = 0; j < name.size(); j++){
                if(tickets[i][0].equals(name.get(j))){
                    
                }
            }
        }



        return new String[]{"hello"};
    }
}
