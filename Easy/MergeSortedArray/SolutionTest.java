import java.util.Arrays;

public class SolutionTest {
    private static int total = 0;
    private static int passed = 0;

    private static void runTest(String name, int[] nums1Input, int m, int[] nums2, int n, int[] expected) {
        total++;
        int[] nums1 = Arrays.copyOf(nums1Input, nums1Input.length);
        try {
            new Solution().merge(nums1, m, nums2, n);
            if (Arrays.equals(expected, nums1)) {
                passed++;
                System.out.println("[PASS] " + name + " => " + Arrays.toString(nums1));
            } else {
                System.out.println("[FAIL] " + name + "\n  expected: " + Arrays.toString(expected) + "\n  actual  : "
                        + Arrays.toString(nums1));
            }
        } catch (Throwable t) {
            System.out.println("[FAIL:EXCEPTION] " + name + " => " + t);
        }
    }

    public static void main(String[] args) {
        // Example 1
        runTest(
                "Example 1 (from prompt)",
                new int[] { 1, 2, 3, 0, 0, 0 }, 3,
                new int[] { 2, 5, 6 }, 3,
                new int[] { 1, 2, 2, 3, 5, 6 });

        // Example 2
        runTest(
                "Example 2 (from prompt)",
                new int[] { 1 }, 1,
                new int[] {}, 0,
                new int[] { 1 });

        // Example 3
        runTest(
                "Example 3 (from prompt)",
                new int[] { 0 }, 0,
                new int[] { 1 }, 1,
                new int[] { 1 });

        // Additional 10 cases
        runTest(
                "All nums2 smaller (prepend)",
                new int[] { 4, 5, 6, 0, 0, 0 }, 3,
                new int[] { 1, 2, 3 }, 3,
                new int[] { 1, 2, 3, 4, 5, 6 });

        runTest(
                "All nums2 larger (append)",
                new int[] { 1, 2, 3, 0, 0, 0 }, 3,
                new int[] { 4, 5, 6 }, 3,
                new int[] { 1, 2, 3, 4, 5, 6 });

        runTest(
                "All elements equal",
                new int[] { 1, 1, 1, 0, 0, 0 }, 3,
                new int[] { 1, 1, 1 }, 3,
                new int[] { 1, 1, 1, 1, 1, 1 });

        runTest(
                "With negatives",
                new int[] { -3, -1, 0, 0, 0 }, 2,
                new int[] { -2, -2, -1 }, 3,
                new int[] { -3, -2, -2, -1, -1 });

        runTest(
                "m = 0 (only nums2)",
                new int[] { 0, 0, 0 }, 0,
                new int[] { 2, 2, 2 }, 3,
                new int[] { 2, 2, 2 });

        runTest(
                "Interleaving with duplicates",
                new int[] { 1, 3, 5, 0, 0, 0, 0 }, 3,
                new int[] { 2, 2, 2, 6 }, 4,
                new int[] { 1, 2, 2, 2, 3, 5, 6 });

        runTest(
                "Single insert at front",
                new int[] { 2, 0 }, 1,
                new int[] { 1 }, 1,
                new int[] { 1, 2 });

        runTest(
                "Single insert in middle",
                new int[] { 1, 2, 4, 5, 6, 0 }, 5,
                new int[] { 3 }, 1,
                new int[] { 1, 2, 3, 4, 5, 6 });

        runTest(
                "Many duplicates in nums2",
                new int[] { 1, 2, 3, 0, 0, 0, 0, 0 }, 3,
                new int[] { 2, 2, 2, 2, 2 }, 5,
                new int[] { 1, 2, 2, 2, 2, 2, 2, 3 });

        runTest(
                "Mixed negatives",
                new int[] { -5, -3, -1, 0, 0, 0 }, 3,
                new int[] { -4, -2, -1 }, 3,
                new int[] { -5, -4, -3, -2, -1, -1 });

        System.out.println();
        System.out.println("Summary: " + passed + "/" + total + " tests passed.");
    }
}
