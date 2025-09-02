package Medium.LongestPalinSubstring;

import java.util.Scanner;

public class Bai_3 {
    public static String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private static boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();

        System.out.print("Enter string: ");
        s = sc.nextLine();

        String result = longestPalindrome(s);

        System.out.print("Longest Palindromic String is: " + result);
    }
}
