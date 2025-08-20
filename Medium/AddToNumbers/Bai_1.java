package Medium.AddToNumbers;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Bai_1 {

    public static boolean checkListNode(ListNode head) {
        int carry = 0;
        while (head != null) {
            if (head.val < 0 && head.val > 9) {
                return false;
            }

            if (head.next == null) {
                return false;
            }
            head = head.next;

            carry++;

            if (carry > 100) {
                return false;
            }
        }

        return true;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode creaListNode(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length for list 1: ");
        int length1 = sc.nextInt();
        int[] arr1 = new int[length1];
        System.out.print("Enter list 1: ");
        for (int i = 0; i < length1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter length for list 2: ");
        int length2 = sc.nextInt();
        int[] arr2 = new int[length2];
        System.out.print("Enter list 2: ");
        for (int i = 0; i < length2; i++) {
            arr2[i] = sc.nextInt();
        }

        ListNode l1 = creaListNode(arr1);
        ListNode l2 = creaListNode(arr2);

        System.out.print("l1: ");
        printListNode(l1);
        System.out.print("l2: ");
        printListNode(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("result: ");
        printListNode(result);

        sc.close();
    }
}