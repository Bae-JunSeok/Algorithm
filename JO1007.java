import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1007 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null) {
            
            StringTokenizer st = new StringTokenizer(line);
            if (line.trim().isEmpty()) {
                continue;
            }
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            boolean leapYear = false;
            boolean error = false;
            int result = 0;

            if (year % 400 == 0) {
                leapYear = true;
            } else if (year % 4 == 0 && year % 100 != 0) {
                leapYear = true;
            }

            int lastDay = 0;
            if(year < 2000 || year > 2010){
                sb.append("INPUT ERROR!\n");
                continue;
            }
            if (month < 1 || month > 12 || day < 1) {
                sb.append("INPUT ERROR!\n");
                continue;
            }
            
            if (month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12) {
                lastDay = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                lastDay = 30;
            } else {
                if (leapYear) {
                    lastDay = 29;
                } else {
                    lastDay = 28;
                }
            }

            if (day > lastDay) {
                sb.append("INPUT ERROR!\n");
                continue;
            }

            // 2000년부터 입력 연도 전까지 날짜 수 더하기
            for (int i = 2000; i < year; i++) {
                boolean leapYear2 = false;

                if (i % 400 == 0) {
                    leapYear2 = true;
                } else if (i % 4 == 0 && i % 100 != 0) {
                    leapYear2 = true;
                }

                if (leapYear2) {
                    result += 366;
                } else {
                    result += 365;
                }
            }

            // 입력 연도의 1월부터 입력 월 전까지 날짜 수 더하기
            for (int i = 1; i < month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 ||
                        i == 8 || i == 10 || i == 12) {
                    result += 31;
                } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                    result += 30;
                } else {
                    if (leapYear) {
                        result += 29;
                    } else {
                        result += 28;
                    }
                }
            }

            // 해당 월 1일의 요일
            int firstDay = (6 + result) % 7;

            // 입력한 day의 요일
            int targetDay = (firstDay + day - 1) % 7;

            String[] week = {
                    "Sunday", "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday", "Saturday"
            };

            sb.append(year).append(". ").append(month).append("\n");
            sb.append("sun mon tue wed thu fri sat\n");

            // 1일 전까지 빈칸 출력
            for (int i = 0; i < firstDay; i++) {
                sb.append("    ");
            }

            // 달력 날짜 출력
            for (int i = 1; i <= lastDay; i++) {
                sb.append(String.format("%3d ", i));

                if ((firstDay + i) % 7 == 0) {
                    sb.append("\n");
                }
            }

            sb.append("\n");
            sb.append(week[targetDay]).append("\n");
        }

        System.out.println(sb);
    }
}