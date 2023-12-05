package adventofcode;

public class E2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode l3 = head;

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

            l3.next = new ListNode(sum % 10);
            l3 = l3.next;

            carry = sum / 10;
        }

        return head.next;
    }

    public static void main(String[] strings) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new E2AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(l3.val == 7);
        System.out.println(l3.next.val == 0);
        System.out.println(l3.next.next.val == 8);

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
