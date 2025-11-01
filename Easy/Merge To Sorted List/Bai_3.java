import java.util.Scanner;

public class Bai_3 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(0);
        ListNode current = newNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return newNode.next;
    }

    
    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val);
            if (list.next != null) {
                System.out.print(" -> ");
            }
            list = list.next;
        }
        System.out.println();
    }

    public static ListNode createList(Scanner sc, int size) {
        if (size == 0) return null;

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < size; i++) {
            int value = sc.nextInt();
            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of List 1: ");
        int sizeList1 = sc.nextInt();

        System.out.print("Enter value of List 1: ");
        ListNode list1 = createList(sc, sizeList1);        
    
        System.out.print("Enter size of List 2: ");
        int sizeList2 = sc.nextInt();

        System.out.print("Enter value of List 2: ");
        ListNode list2 = createList(sc, sizeList2);

        ListNode result = mergeTwoLists(list1, list2);
        printList(result);
        sc.close();
    }
}
