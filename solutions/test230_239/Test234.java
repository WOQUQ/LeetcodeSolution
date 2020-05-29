package test230_239;

public class Test234 {
    // 方法一 - 递归
    ListNode compare;

    public boolean isPalindrome1(ListNode head) {
        // ListNode compare = new ListNode(0);
        // compare.next = head;
        if (head == null)
            return true;
        this.compare = head;
        return helper(head);
    }

    private boolean helper(ListNode node) {
        if (node != null) {
            if (!helper(node.next) || node.val != compare.val)
                return false;
            compare = compare.next;
        }

        return true;
    }

    // 方法二 - 反转前半部分
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        // to compare the two half parts
        ListNode list2 = slow.next;
        slow.next  = pre;
        ListNode list1 = fast == null ? pre : slow;
        
        while (list2 != null) {
            if (list1.val != list2.val)
                return false;

            list2 = list2.next;
            list1 = list1.next;

        }

        return true;

    }

    public static void main(String[] args) {
        Test234 test = new Test234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(test.isPalindrome2(node1));
    }

}