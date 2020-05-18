package test140_149;

public class Test142 {
    //Floyd 算法
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode first = head;
        ListNode second  = head;

        
        do{
            if(second.next == null || second.next.next == null) return null;
            first = first.next;
            second = second.next.next;
        }while(first != second);

        ListNode n1 = first;
        ListNode n2 = head;
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }   
}