public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    // Hàm main để test
    public static void main(String[] args) {
        // Tạo danh sách 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5)))));

        Solution sol = new Solution();
        int n = 1;
        ListNode newHead = sol.removeNthFromEnd(head, n);

        // In danh sách sau khi xóa
        printList(newHead);
    }

    // Hàm tiện ích in danh sách
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}