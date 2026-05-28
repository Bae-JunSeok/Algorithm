import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JO1023 {
    static int test_case;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] suits = new char[5];
            int[] ranks = new int[5];

            for (int i = 0; i < 5; i++) {
                String card = st.nextToken();

                suits[i] = getSuit(card);
                ranks[i] = getRank(card);
            }

            Arrays.sort(ranks);

            boolean flush = isFlush(suits);
            boolean straight = isStraight(ranks);
            boolean royal = isRoyal(ranks);

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int rank : ranks) {
                countMap.put(rank, countMap.getOrDefault(rank, 0) + 1);
            }

            int pairCount = 0;
            boolean three = false;
            boolean four = false;

            for (int count : countMap.values()) {
                if (count == 2) {
                    pairCount++;
                } else if (count == 3) {
                    three = true;
                } else if (count == 4) {
                    four = true;
                }
            }

            if (flush && royal) {
                sb.append("royal flush");
            } else if (flush && straight) {
                sb.append("straight flush");
            } else if (four) {
                sb.append("four of a kind");
            } else if (three && pairCount == 1) {
                sb.append("full house");
            } else if (flush) {
                sb.append("flush");
            } else if (straight) {
                sb.append("straight");
            } else if (three) {
                sb.append("three of a kind");
            } else if (pairCount == 2) {
                sb.append("two pairs");
            } else if (pairCount == 1) {
                sb.append("pair");
            } else {
                sb.append("high card");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static char getSuit(String card) {
        char first = card.charAt(0);

        if (isSuit(first)) {
            return first;
        }

        return card.charAt(card.length() - 1);
    }

    static int getRank(String card) {
        String rank;

        if (isSuit(card.charAt(0))) {
            rank = card.substring(1);
        } else {
            rank = card.substring(0, card.length() - 1);
        }

        if (rank.equals("A")) {
            return 14;
        } else if (rank.equals("K")) {
            return 13;
        } else if (rank.equals("Q")) {
            return 12;
        } else if (rank.equals("J")) {
            return 11;
        } else if (rank.equals("T")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    static boolean isSuit(char c) {
        return c == 'S' || c == 'D' || c == 'H' || c == 'C';
    }

    static boolean isFlush(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                return false;
            }
        }

        return true;
    }

    static boolean isStraight(int[] ranks) {
        // A, 2, 3, 4, 5 스트레이트 처리
        if (ranks[0] == 2 &&
            ranks[1] == 3 &&
            ranks[2] == 4 &&
            ranks[3] == 5 &&
            ranks[4] == 14) {
            return true;
        }

        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] != ranks[i - 1] + 1) {
                return false;
            }
        }

        return true;
    }

    static boolean isRoyal(int[] ranks) {
        return ranks[0] == 10 &&
               ranks[1] == 11 &&
               ranks[2] == 12 &&
               ranks[3] == 13 &&
               ranks[4] == 14;
    }
}