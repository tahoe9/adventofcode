package adventofcode;

public class E141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = slow.next;
        while(fast != null && fast.next != null) {
            if (fast == slow) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] strings) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;

        System.out.println(new E141LinkedListCycle().hasCycle(root) == true);
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
