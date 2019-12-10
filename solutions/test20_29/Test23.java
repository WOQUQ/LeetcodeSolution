package test20_29;

import java.util.Arrays;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @author WOQUQ
 *
 */
public class Test23 {
    public static ListNode mergeKLists(ListNode[] lists) {
    	int size = lists.length;
    	if(size == 0) return null;
    	if(size == 1) return lists[0];
    	if(size == 2) return mergeTwoLists(lists[0],lists[1]);
    	
    	ListNode[] temp = new ListNode[2];
    	temp[0] = mergeKLists( Arrays.copyOfRange(lists, 0, size/2) );
    	temp[1] = mergeKLists(Arrays.copyOfRange(lists, size/2, size));
    	return mergeKLists(temp);

    }	
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

	public static void main(String[] args) {
		int[] test = {1,2,3,4};
		System.out.println(Arrays.copyOfRange(test, 1, 3)[1]);
	}
}
