import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Bai_2 {
    public static boolean check(String s) {
        if (s.length() < 1 || s.length() > 15) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'I' &&
                    c != 'V' &&
                    c != 'X' &&
                    c != 'L' &&
                    c != 'C' &&
                    c != 'D' &&
                    c != 'M') {
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Roman: ");
        String s = sc.nextLine().toUpperCase();

        if (check(s)) {
            int result = romanToInt(s);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid Roman number!");
        }

        sc.close();
    }
}
