import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG92341 {
    public static void main(String[] args) {
        PG92341 sol = new PG92341();
        System.out.println(sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public int[] solution(int[] fees, String[] records){
        
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> in = new HashMap<>();
        HashMap<String, ArrayList<Integer>> out = new HashMap<>();

        int n = records.length;
        
        ArrayList<String> cars = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] input = records[i].split(" ");
            String[] time = input[0].split(":");
            String carNumber = input[1];
            if(!cars.contains(carNumber)){
                cars.add(carNumber);
            }
            String inOrOut = input[2];
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            if(inOrOut.equals("IN")){
                if(!in.containsKey(carNumber)){
                    in.put(carNumber, new ArrayList<>());
                }

                in.get(carNumber).add(hour * 60 + minute);
            } else {
                if(!out.containsKey(carNumber)){
                    out.put(carNumber, new ArrayList<>());
                }

                out.get(carNumber).add(hour * 60 + minute);
            }
        }

        Collections.sort(cars);

        for(int i = 0; i < cars.size(); i++){
            ArrayList<Integer> a = in.get(cars.get(i));
            ArrayList<Integer> b = out.get(cars.get(i));
            if(b == null){
                b = new ArrayList<>();
            }

            if(a.size() > b.size()){
                b.add(23 * 60 + 59);
            }

            int midResult = 0;
            for(int j = 0; j < a.size(); j++){
                midResult += (b.get(j) - a.get(j));
            }

            if(midResult > fees[0]){
                result.add(fees[1] + (int)Math.ceil((double)(midResult - fees[0]) / fees[2]) * fees[3]);
            } else {
                result.add(fees[1]);
            }
        }

        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
            // System.out.println(result.get(i));
        }

        return answer;
    }
}


