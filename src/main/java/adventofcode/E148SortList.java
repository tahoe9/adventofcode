package adventofcode;

public class E148SortList {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (head != null) {
            ListNode next = head.next;
            if (prev.val >= head.val)
                prev = dummy;
            while (prev.next != null && prev.next.val < head.val)
                prev = prev.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] strings) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(3);


        ListNode result = new E148SortList().sortList(l);
        System.out.println(result.val == 1);
        System.out.println(result.next.val == 2);
        System.out.println(result.next.next.val == 3);
        System.out.println(result.next.next.next.val == 4);
    }


}
