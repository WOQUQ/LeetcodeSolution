package test20_29;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author WOQUQ
 *
 */
public class Test21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res = null;
		if(l1 == null && l2 == null) return res;
		else if(l1 == null) {
			return l2;
		}else if(l2 == null){
			return l1;
		}
		if(l1.val > l2.val) {
			res = l2;
			l2 = l2.next;
		}else {
			res = l1;
			l1 = l1.next;
		}
		
		ListNode temp = res;
		while(l1 != null || l2 != null) {
			if(l1 == null) {
				temp.next = l2;
				break;
			}
			if(l2 == null) {
				temp.next = l1;
				break;
			}
			if(l1.val > l2.val) {
				temp.next = l2;
				l2 = l2.next;
			}else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		
		return res;
	}
}
