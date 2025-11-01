package Hard.FindMiddleNumber;
import java.util.Scanner;

public class Bai_1 {
    public static int[] createNums(int length) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        return nums;
    }

    public static void printNums(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.print(" ]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums1, nums2;
        int lengthNums1, lengthNums2 = 0;

        System.out.print("Enter length of nums 1: ");
        lengthNums1 = sc.nextInt();
        System.out.print("Enter nums 1: ");
        nums1 = createNums(lengthNums1);

        System.out.print("Enter length of nums 2: ");
        lengthNums2 = sc.nextInt();
        System.out.print("Enter nums 2: ");
        nums2 = createNums(lengthNums2);

        printNums(nums1);
        printNums(nums2);
    }
}
