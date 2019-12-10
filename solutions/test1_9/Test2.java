package test1_9;



public class Test2 {
	int carry = 0;
	int result = 0;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 != null || l2 != null || carry == 1) {
			if(l1 == null) {
				l1 = new ListNode(0);
			}
			if(l2 == null) {
				l2 = new ListNode(0);
			}
			result = l1.val + l2.val + carry;
			carry = 0;
			if(result > 9) {
				carry++;
				result -= 10;
			}
			ListNode listNode = new ListNode(result);
			listNode.next = addTwoNumbers(l1.next,l2.next);
			return listNode;
		}else {
			return null;
		}
	}
}
