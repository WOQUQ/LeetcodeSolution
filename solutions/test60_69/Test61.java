package test60_69;

public class Test61 {
    // 方法一 双指针
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for(int i  = 0; i < k; i++){
            fast = fast.next == null ? head : fast.next;
        }

        if(fast == slow){
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }

        // 方法二 环
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null) return null;
        if (head.next == null) return head;

        ListNode oldEnd = head;
        int n;
        for(n = 1;oldEnd.next != null; n++){
            oldEnd = oldEnd.next;
        }

        oldEnd.next = head;
        ListNode newEnd = head;
        for(int i = 0; i < n - k % n - 1; i++){
            newEnd = newEnd.next;
        }
        ListNode res = newEnd.next;
        newEnd.next = null;
        return res;
    }
}