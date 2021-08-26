//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1643 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 递归法
    /*
    public ListNode reverseList(ListNode head) {
        // 健壮性判断与递归中止条件
        if(head == null || head.next == null) {
            return head;
        }
        // 反转链表的头节点
        ListNode newListNode = reverseList(head.next);
        // 将当前节点的后一位指向当前节点，形成循环链表
        head.next.next = head;
        // 断开循环链表，造成局部反转
        head.next = null;
        return newListNode;

    }*/

    // 迭代法
    /*public ListNode reverseList(ListNode head) {
        // 前驱节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        // 后继节点
        ListNode next = head;

        // 遍历链表
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }*/

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
