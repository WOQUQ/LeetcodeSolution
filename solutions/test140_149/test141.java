package test140_149;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Test141{
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode first = head;
        ListNode second  = head.next;

        
        while(first != second){
            first = first.next;
            if(second.next == null || second.next.next == null) return false;
            second = second.next.next;
        }

        return true;
    }
}