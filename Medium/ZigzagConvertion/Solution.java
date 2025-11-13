public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean isGoing = false;
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                isGoing = !isGoing;
            }

            currentRow += isGoing ? 1 : -1;
        }

        for (StringBuilder rowBuilder : rows) {
            result.append(rowBuilder);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "PAYPALISHIRING";
        System.out.println("Input: " + s1 + ", numRows: 3");
        System.out.println("Output: " + convert(s1, 3));
        System.out.println("Expected: PAHNAPLSIIGYIR\n");

        // Test case 2
        String s2 = "PAYPALISHIRING";
        System.out.println("Input: " + s2 + ", numRows: 4");
        System.out.println("Output: " + convert(s2, 4));
        System.out.println("Expected: PINALSIGYAHRPI\n");

        // Test case 3
        String s3 = "A";
        System.out.println("Input: " + s3 + ", numRows: 1");
        System.out.println("Output: " + convert(s3, 1));
        System.out.println("Expected: A");
    }
}