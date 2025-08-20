package Medium.LongestSubstring;

import java.util.Scanner;
import java.lang.String;

public class Bai_2 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[] last = new int[256];
        for (int i = 0; i < last.length; i++) last[i] = -1;

        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (last[c] >= left) {
                left = last[c] + 1;
            }

            last[c] = right;
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s = ");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);
        System.out.println("Longest length = " + result);

        sc.close();
    }
}
