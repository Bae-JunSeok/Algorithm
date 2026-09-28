import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO7009 {

    static int n, m;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> member = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            member.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(member);

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {

            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n - 1;
            boolean found = false;

            while (left <= right) {

                int mid = (left + right) / 2;

                if (member.get(mid) == target) {
                    found = true;
                    break;
                }

                if (member.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (!found) {
                sb.append(target).append(" ");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}