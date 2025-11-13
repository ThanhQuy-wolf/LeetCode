public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // con trỏ nums1 (vùng dữ liệu thật)
        int j = n - 1;        // con trỏ nums2
        int k = m + n - 1;    // con trỏ ghi vào cuối nums1

        // so sánh từ cuối, đặt phần tử lớn hơn về cuối
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                
                nums1[k--] = nums2[j--];
            }
        }

        // nếu nums2 còn dư, chép nốt (nums1 dư thì đã ở đúng chỗ)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}