import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Math.max(1, lists.length), (a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) pq.offer(node.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: lists = [[1,4,5],[1,3,4],[2,6]]
        // Output: [1,1,2,3,4,4,5,6]
        int[][] ex1 = new int[][] { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
        ListNode[] lists1 = buildLists(ex1);
        try {
            ListNode merged1 = new Solution().mergeKLists(lists1);
            System.out.print("Example 1 output: ");
            printList(merged1);
        } catch (Exception e) {
            System.out.println("Example 1 threw exception: " + e.getMessage());
        }

        // Example 2:
        // Input: lists = []
        // Output: []
        ListNode[] lists2 = new ListNode[] {};
        try {
            ListNode merged2 = new Solution().mergeKLists(lists2);
            System.out.print("Example 2 output: ");
            printList(merged2);
        } catch (Exception e) {
            System.out.println("Example 2 threw exception: " + e.getMessage());
        }

        // Example 3:
        // Input: lists = [[]]
        // Output: []
        int[][] ex3 = new int[][] { {} };
        ListNode[] lists3 = buildLists(ex3);
        try {
            ListNode merged3 = new Solution().mergeKLists(lists3);
            System.out.print("Example 3 output: ");
            printList(merged3);
        } catch (Exception e) {
            System.out.println("Example 3 threw exception: " + e.getMessage());
        }
    }

    // --- Helpers for building and printing lists for tests ---
    static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    static ListNode[] buildLists(int[][] arrays) {
        if (arrays == null)
            return new ListNode[] {};
        ListNode[] res = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            res[i] = buildList(arrays[i]);
        }
        return res;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null)
                sb.append(',').append(' ');
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}