class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int medium = 0;
        int hight = nums.length - 1;

        while (medium <= hight) {
            if (nums[medium] == 0) {
                int temp = nums[medium];
                nums[medium] = nums[low];
                nums[low] = temp;

                low++;
                medium++;
            } else if (nums[medium] == 1) {
                medium++;
            } else {
                int temp = nums[medium];
                nums[medium] = nums[hight];
                nums[hight] = temp;
                // IMPORTANT: do not advance 'medium' here, because the value
                // swapped from the end hasn't been examined yet.
                hight--;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int passed = 0;
        int total = 12;

        // 1) Example 1
        passed += assertSort(sol, new int[] { 2, 0, 2, 1, 1, 0 }, new int[] { 0, 0, 1, 1, 2, 2 }, "Example 1");

        // 2) Example 2
        passed += assertSort(sol, new int[] { 2, 0, 1 }, new int[] { 0, 1, 2 }, "Example 2");

        // 3) Already sorted
        passed += assertSort(sol, new int[] { 0, 0, 1, 1, 2, 2 }, new int[] { 0, 0, 1, 1, 2, 2 }, "Already sorted");

        // 4) Reverse sorted
        passed += assertSort(sol, new int[] { 2, 2, 1, 1, 0, 0 }, new int[] { 0, 0, 1, 1, 2, 2 }, "Reverse sorted");

        // 5) Single element 0
        passed += assertSort(sol, new int[] { 0 }, new int[] { 0 }, "Single 0");

        // 6) Single element 1
        passed += assertSort(sol, new int[] { 1 }, new int[] { 1 }, "Single 1");

        // 7) Single element 2
        passed += assertSort(sol, new int[] { 2 }, new int[] { 2 }, "Single 2");

        // 8) All zeros
        passed += assertSort(sol, new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 }, "All zeros");

        // 9) All ones
        passed += assertSort(sol, new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 }, "All ones");

        // 10) All twos
        passed += assertSort(sol, new int[] { 2, 2, 2, 2, 2 }, new int[] { 2, 2, 2, 2, 2 }, "All twos");

        // 11) Alternating pattern
        passed += assertSort(sol, new int[] { 0, 2, 1, 0, 2, 1, 0, 2, 1 }, new int[] { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
                "Alternating 0/1/2");

        // 12) Random mix with equal counts
        passed += assertSort(sol, new int[] { 2, 1, 0, 2, 1, 0, 2, 1, 0 }, new int[] { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
                "Random mix equal counts");

        System.out.println();
        System.out.println("Passed " + passed + " / " + total + " tests.");
    }

    private static int assertSort(Solution sol, int[] input, int[] expected, String name) {
        int[] arr = input.clone();
        sol.sortColors(arr);
        boolean ok = java.util.Arrays.equals(arr, expected);
        if (ok) {
            System.out.println("[PASS] " + name + " -> " + java.util.Arrays.toString(arr));
            return 1;
        } else {
            System.out.println("[FAIL] " + name + "\n  expected: " + java.util.Arrays.toString(expected) +
                    "\n  actual:   " + java.util.Arrays.toString(arr));
            return 0;
        }
    }
}