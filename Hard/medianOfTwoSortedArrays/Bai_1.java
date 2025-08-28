package Hard.medianOfTwoSortedArrays;
import java.util.Scanner;

public class Bai_1 {
    public static int[] createNums(Scanner sc, int length) {
        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        return nums;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int target = total / 2;

        int i = 0, j = 0;
        int count = -1;
        double prev = 0, curr = 0;

        while (count <= target) {
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            count++;
        }

        if ((total & 1) == 1) {
            return curr;
        } else {
            return (prev + curr) / 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthNums1, lengthNums2;
        int[] nums1, nums2;

        System.out.print("Enter length of nums1: ");
        lengthNums1 = sc.nextInt();
        System.out.print("Enter nums1: ");
        nums1 = createNums(sc, lengthNums1);

        System.out.print("Enter length of nums2: ");
        lengthNums2 = sc.nextInt();
        System.out.print("Enter nums2: ");
        nums2 = createNums(sc, lengthNums2);

        double median = findMedianSortedArrays(nums1,nums2);
        System.out.println("Median = " + median);
        sc.close();
    }
}
