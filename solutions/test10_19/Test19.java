package test10_19;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author WOQUQ
 *
 */
public class Test19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		boolean flag = false;
		for(int i = 0; i < n+1; i++) {
			if(first == null) {
				flag = true;
				break;
			}
			first = first.next;
		}
		for(;;) {
			if(first == null) break;
			second = second.next;
			first = first.next;
		}
		if(flag) head = head.next;
		else second.next = second.next.next;
		
		return head;
	}
}
