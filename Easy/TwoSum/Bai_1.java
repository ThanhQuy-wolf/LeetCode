package Easy.TwoSum;

import java.util.Scanner;
import java.util.Arrays;

public class Bai_1 {

    public static boolean check(int[] nums, int target) {
        if (nums.length < 2 || nums.length > Math.pow(10, 4)) {
            return false;
        }

        if (target < -Math.pow(10, 9) || target > Math.pow(10, 9)) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -Math.pow(10, 9) || nums[i] > Math.pow(10, 9)) {
                return false;
            }
        }

        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        int saveNum = 0;
        int[] result = { 0, 0 };

        for (int i = 0; i < nums.length; i++) {
            saveNum = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (saveNum == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int length = sc.nextInt();

        nums = new int[length];

        System.err.print("Enter array elements: ");
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }

        System.err.print("Enter target: ");
        int target = sc.nextInt();

        if (check(nums, target)) {
            int[] result = twoSum(nums, target);
            System.out.println("Result: " + Arrays.toString(result));
        } else {
            System.out.println("Invalid input!");
        }
        sc.close();
    }
}
