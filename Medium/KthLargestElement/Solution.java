import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;
        int out1 = sol.findKthLargest(nums1, k1);
        System.out.println("Example 1:");
        System.out.println("Input:  nums = " + Arrays.toString(nums1).replace(" ", "") + ",  k = " + k1);
        System.out.println("Output: " + out1);
        System.out.println();

        // Example 2
        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        int out2 = sol.findKthLargest(nums2, k2);
        System.out.println("Example 2:");
        System.out.println("Input:  nums = " + Arrays.toString(nums2).replace(" ", "") + ",  k = " + k2);
        System.out.println("Output: " + out2);
        System.out.println();

        // ----- Additional test cases -----

        // 1) Single element
        int[] t1 = { 42 };
        int k_t1 = 1;
        System.out.println("Test 1 (single element):");
        System.out.println("Input:  nums = " + Arrays.toString(t1).replace(" ", "") + ",  k = " + k_t1);
        System.out.println("Output: " + sol.findKthLargest(t1, k_t1));
        System.out.println();

        // 2) All elements equal
        int[] t2 = { 5, 5, 5, 5 };
        int k_t2 = 3;
        System.out.println("Test 2 (all equal):");
        System.out.println("Input:  nums = " + Arrays.toString(t2).replace(" ", "") + ",  k = " + k_t2);
        System.out.println("Output: " + sol.findKthLargest(t2, k_t2));
        System.out.println();

        // 3) Negatives only
        int[] t3 = { -1, -2, -3, -4 };
        int k_t3 = 2;
        System.out.println("Test 3 (negatives only):");
        System.out.println("Input:  nums = " + Arrays.toString(t3).replace(" ", "") + ",  k = " + k_t3);
        System.out.println("Output: " + sol.findKthLargest(t3, k_t3));
        System.out.println();

        // 4) Mixed negative/positive
        int[] t4 = { -10, 0, 5, -7, 8, 3 };
        int k_t4 = 4;
        System.out.println("Test 4 (mixed signs):");
        System.out.println("Input:  nums = " + Arrays.toString(t4).replace(" ", "") + ",  k = " + k_t4);
        System.out.println("Output: " + sol.findKthLargest(t4, k_t4));
        System.out.println();

        // 5) Duplicates around the max
        int[] t5 = { 5, 3, 5, 4, 5 };
        int k_t5 = 4;
        System.out.println("Test 5 (duplicates, near max):");
        System.out.println("Input:  nums = " + Arrays.toString(t5).replace(" ", "") + ",  k = " + k_t5);
        System.out.println("Output: " + sol.findKthLargest(t5, k_t5));
        System.out.println();

        // 6) k = n (smallest element)
        int[] t6 = { 9, 8, 7 };
        int k_t6 = 3;
        System.out.println("Test 6 (k = n, smallest):");
        System.out.println("Input:  nums = " + Arrays.toString(t6).replace(" ", "") + ",  k = " + k_t6);
        System.out.println("Output: " + sol.findKthLargest(t6, k_t6));
        System.out.println();

        // 7) Already ascending
        int[] t7 = { 1, 2, 3, 4, 5 };
        int k_t7 = 2;
        System.out.println("Test 7 (ascending array):");
        System.out.println("Input:  nums = " + Arrays.toString(t7).replace(" ", "") + ",  k = " + k_t7);
        System.out.println("Output: " + sol.findKthLargest(t7, k_t7));
        System.out.println();

        // 8) Already descending
        int[] t8 = { 9, 7, 5, 3, 1 };
        int k_t8 = 5;
        System.out.println("Test 8 (descending array):");
        System.out.println("Input:  nums = " + Arrays.toString(t8).replace(" ", "") + ",  k = " + k_t8);
        System.out.println("Output: " + sol.findKthLargest(t8, k_t8));
        System.out.println();

        // 9) Extreme int values
        int[] t9 = { Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE };
        int k_t9 = 2;
        System.out.println("Test 9 (int extremes):");
        System.out.println("Input:  nums = " + Arrays.toString(t9).replace(" ", "") + ",  k = " + k_t9);
        System.out.println("Output: " + sol.findKthLargest(t9, k_t9));
        System.out.println();

        // 10) Many duplicates with multiple values
        int[] t10 = { 2, 2, 1, 1, 3, 3 };
        int k_t10 = 4;
        System.out.println("Test 10 (many duplicates):");
        System.out.println("Input:  nums = " + Arrays.toString(t10).replace(" ", "") + ",  k = " + k_t10);
        System.out.println("Output: " + sol.findKthLargest(t10, k_t10));
    }
}