package test140_149;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Test148 {

    // 方法一 自顶向下
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 通过快慢指针法找到链表中间点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 将链表一分为二，分别进行递归
        ListNode temp = slow.next;
        slow.next = null;
        ListNode listLeft = sortList(head);
        ListNode listRight = sortList(temp);

        // 合并两个有序链表
        temp = mergeLists(listLeft, listRight);

        return temp;
    }

    private ListNode mergeLists(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        // 辅助节点，并不包含在结果内
        ListNode head = new ListNode(0);

        ListNode node = head;
        while (node1 != null || node2 != null) {
            if (node1 == null || node2 == null) {
                node.next = (node1 == null) ? node2 : node1;
                break;
            }
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;

        }

        return head.next;
    }

    // 方法二 自底向上
    // public ListNode sortList2(ListNode head) {
    //     if (head == null || head.next == null)
    //         return head;
        
    //     int toBreak = 0;
    //     // 从底层每两个开始合并，之后4,8,16
    //     for (int i = 1; toBreak != 0; i *= 2) {
    //         toBreak = 0;

    //         //准备合并的两组
    //         ListNode list1 = new ListNode(0);
    //         ListNode list2= new ListNode(0);
            
    //         //两组末尾
    //         ListNode end1= new ListNode(0);
    //         ListNode end2= new ListNode(0);

    //         //辅助头
    //         ListNode help = new ListNode(0);
    //         help.next = head;

    //         //两组前后
    //         ListNode pre = help;
    //         ListNode next;

    //         //从head开始遍历，每次合并两组，各i个节点
    //         ListNode node = head;
    //         int count = 0;
            
    //         while(node != null){
                
    //             if(count == 0){
    //                 list1 = node;
    //             }
                
    //             if(count == i-1){
    //                 end1 = node;
    //                 list2 = node.next;
    //             }
                
    //             if(count == 2*i - 1 || node.next == null){
    //                 end2 = node;
    //                 next = node.next;

    //                 //断开两组
    //                 end1.next = null;
    //                 end2.next = null;

    //                 //合并
    //                 ListNode newList = mergeLists(list1, list2);
    //                 pre.next = newList;
    //                 while(newList.next != null){
    //                     newList = newList.next;
    //                 }
    //                 newList.next = next;
    //                 node = next;
                    

    //                 toBreak++;
    //                 pre = newList;
    //                 count = 0;

    //                 if(node == null) break;
    //                 continue;
    //             }
                

    //             count++;
    //             node = node.next;

    //         }
    //     }
    //     return head;

    // }

    // test
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        Test148 test = new Test148();
        // test.sortList2(head);
    }
}