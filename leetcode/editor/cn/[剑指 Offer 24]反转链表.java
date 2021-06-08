//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 205 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
        ListNode newHead = reverseList(head.next);
        // 将当前节点的后一位指向当前节点，形成循环链表
        head.next.next = head;
        // 断开循环链表，造成局部反转
        head.next = null;
        return newHead;
    }
    */

    // 迭代法
    public ListNode reverseList(ListNode head) {
        // 前驱节点
        ListNode pre = null;
        // 后继节点
        ListNode cur = head;

        // 遍历链表
        while(cur != null) {
            // 记录在原链表中当前节点的下一节点
            ListNode next = cur.next;
            // 当前节点指向前驱节点
            cur.next = pre;
            // 前驱节点后移一位
            pre = cur;
            // 当前节点后移一位
            cur = next;
        }
        // 返回原链表中的最后一位节点
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
