public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur_m = m - 1;
        int cur_n = n - 1;
        int cur_nums1 = m + n - 1;

        while (cur_m >= 0 && cur_n >= 0) {
            if (nums1[cur_m] > nums2[cur_n]) {
                nums1[cur_nums1--] = nums1[cur_m--];
            } else {
                nums1[cur_nums1--] = nums2[cur_n--];
            }
        }

        while (cur_n >= 0) {
            nums1[cur_nums1--] = nums2[cur_n--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases from examples

        // Example 1: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        System.out.println("Example 1:");
        int[] nums1_1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2_1 = { 2, 5, 6 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_1) + ", nums2 = "
                + java.util.Arrays.toString(nums2_1));
        solution.merge(nums1_1, 3, nums2_1, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_1));
        System.out.println("Expected: [1, 2, 2, 3, 5, 6]\n");

        // Example 2: nums1 = [1], m = 1, nums2 = [], n = 0
        System.out.println("Example 2:");
        int[] nums1_2 = { 1 };
        int[] nums2_2 = {};
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_2) + ", nums2 = "
                + java.util.Arrays.toString(nums2_2));
        solution.merge(nums1_2, 1, nums2_2, 0);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_2));
        System.out.println("Expected: [1]\n");

        // Example 3: nums1 = [0], m = 0, nums2 = [1], n = 1
        System.out.println("Example 3:");
        int[] nums1_3 = { 0 };
        int[] nums2_3 = { 1 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_3) + ", nums2 = "
                + java.util.Arrays.toString(nums2_3));
        solution.merge(nums1_3, 0, nums2_3, 1);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_3));
        System.out.println("Expected: [1]\n");

        // Additional test cases

        // Test case 4: All elements in nums2 are smaller
        System.out.println("Test case 4: All elements in nums2 are smaller");
        int[] nums1_4 = { 4, 5, 6, 0, 0, 0 };
        int[] nums2_4 = { 1, 2, 3 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_4) + ", nums2 = "
                + java.util.Arrays.toString(nums2_4));
        solution.merge(nums1_4, 3, nums2_4, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_4));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]\n");

        // Test case 5: All elements in nums2 are larger
        System.out.println("Test case 5: All elements in nums2 are larger");
        int[] nums1_5 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2_5 = { 4, 5, 6 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_5) + ", nums2 = "
                + java.util.Arrays.toString(nums2_5));
        solution.merge(nums1_5, 3, nums2_5, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_5));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]\n");

        // Test case 6: Duplicate elements
        System.out.println("Test case 6: Duplicate elements");
        int[] nums1_6 = { 1, 2, 3, 0, 0, 0, 0 };
        int[] nums2_6 = { 2, 3, 4, 5 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_6) + ", nums2 = "
                + java.util.Arrays.toString(nums2_6));
        solution.merge(nums1_6, 3, nums2_6, 4);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_6));
        System.out.println("Expected: [1, 2, 2, 3, 3, 4, 5]\n");

        // Test case 7: Single element in each array
        System.out.println("Test case 7: Single element in each array");
        int[] nums1_7 = { 2, 0 };
        int[] nums2_7 = { 1 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_7) + ", nums2 = "
                + java.util.Arrays.toString(nums2_7));
        solution.merge(nums1_7, 1, nums2_7, 1);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_7));
        System.out.println("Expected: [1, 2]\n");

        // Test case 8: Negative numbers
        System.out.println("Test case 8: Negative numbers");
        int[] nums1_8 = { -3, -1, 0, 0, 0 };
        int[] nums2_8 = { -2, 0, 1 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_8) + ", nums2 = "
                + java.util.Arrays.toString(nums2_8));
        solution.merge(nums1_8, 2, nums2_8, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_8));
        System.out.println("Expected: [-3, -2, -1, 0, 1]\n");

        // Test case 9: Large numbers
        System.out.println("Test case 9: Large numbers");
        int[] nums1_9 = { 1000000, 2000000, 0 };
        int[] nums2_9 = { 1500000 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_9) + ", nums2 = "
                + java.util.Arrays.toString(nums2_9));
        solution.merge(nums1_9, 2, nums2_9, 1);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_9));
        System.out.println("Expected: [1000000, 1500000, 2000000]\n");

        // Test case 10: Interleaved pattern
        System.out.println("Test case 10: Interleaved pattern");
        int[] nums1_10 = { 1, 3, 5, 0, 0, 0 };
        int[] nums2_10 = { 2, 4, 6 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_10) + ", nums2 = "
                + java.util.Arrays.toString(nums2_10));
        solution.merge(nums1_10, 3, nums2_10, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_10));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]\n");

        // Test case 11: All zeros
        System.out.println("Test case 11: All zeros");
        int[] nums1_11 = { 0, 0, 0, 0 };
        int[] nums2_11 = { 0, 0 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_11) + ", nums2 = "
                + java.util.Arrays.toString(nums2_11));
        solution.merge(nums1_11, 2, nums2_11, 2);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_11));
        System.out.println("Expected: [0, 0, 0, 0]\n");

        // Test case 12: Identical arrays
        System.out.println("Test case 12: Identical arrays");
        int[] nums1_12 = { 5, 5, 5, 0, 0, 0 };
        int[] nums2_12 = { 5, 5, 5 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_12) + ", nums2 = "
                + java.util.Arrays.toString(nums2_12));
        solution.merge(nums1_12, 3, nums2_12, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_12));
        System.out.println("Expected: [5, 5, 5, 5, 5, 5]\n");

        // Test case 13: Only nums2 has elements
        System.out.println("Test case 13: Only nums2 has elements");
        int[] nums1_13 = { 0, 0, 0 };
        int[] nums2_13 = { 1, 2, 3 };
        System.out.print("Before: nums1 = " + java.util.Arrays.toString(nums1_13) + ", nums2 = "
                + java.util.Arrays.toString(nums2_13));
        solution.merge(nums1_13, 0, nums2_13, 3);
        System.out.println(" -> After: " + java.util.Arrays.toString(nums1_13));
        System.out.println("Expected: [1, 2, 3]\n");
    }
}
