package test160_169;

public class Test160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(true){

            if(tempA == null && tempB != null)
                tempA = headB;
            if(tempB == null && tempA != null)
                tempB = headA;
            if(tempA == null && tempB == null)
                return null;    
            if(tempA == tempB)
                return tempA;

            tempA = tempA.next;
            tempB = tempB.next;
        }
    }   
}