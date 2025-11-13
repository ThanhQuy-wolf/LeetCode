import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Đảm bảo nums1 là mảng ngắn hơn để tối ưu hóa
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            // Chia nums1 tại vị trí i
            int i = (low + high) / 2;
            // Chia nums2 tại vị trí j sao cho tổng left part = (m+n+1)/2
            int j = (m + n + 1) / 2 - i;

            // Lấy các giá trị biên
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Kiểm tra điều kiện partition hợp lệ
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Tìm được partition đúng
                if ((m + n) % 2 == 1) {
                    // Tổng số phần tử lẻ -> median là max của left part
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Tổng số phần tử chẵn -> median là trung bình của max(left) và min(right)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // i quá lớn, cần giảm i
                high = i - 1;
            } else {
                // i quá nhỏ, cần tăng i
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: nums1 = [1,3], nums2 = [2]
        // Expected output: 2.00000
        int[] nums1_1 = { 9,4};
        int[] nums2_1 = { 10,6,8,5 };
        double result1 = solution.findMedianSortedArrays(nums1_1, nums2_1);
        System.out.println("Example 1:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_1) + ", nums2 = " + Arrays.toString(nums2_1));
        System.out.println("Output: " + String.format("%.5f", result1));
        System.out.println("Expected: 2.00000");
    }
}