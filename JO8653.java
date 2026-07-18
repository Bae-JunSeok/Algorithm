import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO8653 {
    static int n, q;
    static long[] arr;
    static int peak;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        peak = findPeak();

        for (int i = 0; i < q; i++) {
            long target = Long.parseLong(br.readLine());

            if (arr[peak] == target) {
                sb.append("T\n");
            } else if (ascendingBinarySearch(0, peak - 1, target)) {
                sb.append("L\n");
            } else if (descendingBinarySearch(peak + 1, n - 1, target)) {
                sb.append("R\n");
            } else {
                sb.append("N\n");
            }
        }

        System.out.print(sb);
    }

    static int findPeak() {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static boolean ascendingBinarySearch(
            int left, int right, long target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    static boolean descendingBinarySearch(
            int left, int right, long target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (target < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}