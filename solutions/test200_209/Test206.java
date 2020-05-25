package test200_209;

public class Test206 {
    //迭代
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode pre = head;
        ListNode curr = head.next;
        if(curr == null) return head;
        head.next = null;
        while(curr.next != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;

        return curr;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head.next;
        head.next = null;
        return helper(curr,head);
        
    }

    private ListNode helper(ListNode curr,ListNode pre){
        if(curr.next == null){
            curr.next = pre;
            return curr;
        }
        ListNode result= helper(curr.next,curr);
        curr.next = pre;
        return result;
    }
}