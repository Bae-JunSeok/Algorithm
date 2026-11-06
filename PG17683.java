import java.util.ArrayList;

public class PG17683 {
    public static void main(String[] args) {
        PG17683 sol = new PG17683();
        System.out.println(sol.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
    }

    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "c")
        .replace("D#", "d")
        .replace("F#", "f")
        .replace("G#", "g")
        .replace("A#", "a")
        .replace("B#", "b");
        String answer = "";
        int count = 0; // 갯수를 세기 위한 변수
        int time = 0;   // 길이를 세기 위한 변수
        int index = -1; // 인덱스 구하기 위한 변수
        ArrayList<String> result = new ArrayList<>(); 
        ArrayList<String> titles = new ArrayList<>();
        for(int i = 0; i < musicinfos.length; i++){
            String[] input = musicinfos[i].split(",");
            String startTime = input[0];
            String endTime = input[1];
            String title = input[2];
            titles.add(title);
            String lyrics = input[3];
            lyrics = lyrics.replace("C#", "c")
               .replace("D#", "d")
               .replace("F#", "f")
               .replace("G#", "g")
               .replace("A#", "a")
               .replace("B#", "b");
            int startHour = Integer.parseInt(startTime.split(":")[0]);
            int startMinute = Integer.parseInt(startTime.split(":")[1]);
            int endHour = Integer.parseInt(endTime.split(":")[0]);
            int endMinute = Integer.parseInt(endTime.split(":")[1]);
            int totalTime = (endHour * 60 + endMinute) - (startHour * 60 + startMinute);

            String s = "";
            for(int j = 0; j < totalTime; j++){
                s += lyrics.charAt(j % lyrics.length());
            }

            result.add(s);
        }

        for(int i = 0; i < result.size(); i++){
            if(result.get(i).contains(m)){
                count++;
                index = i;
            }
        }

        if(count >= 2){
            index = -1;
            for(int i = 0; i < result.size(); i++){
                if(result.get(i).contains(m)){
                    if(result.get(i).length() > time){
                        index = i;
                        time = result.get(i).length();
                    }
                }
            }
            answer = titles.get(index);
        } else if(count == 0){
            answer = "None";
        } else if(count == 1){
            answer = titles.get(index);
        }
        
        return answer;
    }
}
