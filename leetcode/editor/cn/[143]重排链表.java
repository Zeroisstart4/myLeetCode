//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 栈 递归 链表 双指针 
// 👍 606 👎 0


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
    public void reorderList(ListNode head) {

        // 健壮性判断
        if (head == null || head.next == null) {
            return;
        }

        // 链表中间节点
        ListNode mid = middleNode(head);
        // 将链表一分为二
        ListNode l1 = head;
        ListNode l2 = mid.next;
        // 断开链表
        mid.next = null;
        // 反转后半段
        l2 = reverseList(l2);
        // 合并
        mergeTwo(l1, l2);
    }

    /**
     * 查找链表的中间点
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {

        // 健壮性判断
        if(head == null || head.next == null) {
            return head;
        }

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 遍历
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     *  反转链表
     * @param head
     */
    private ListNode reverseList(ListNode head) {

        // 健壮性判断
        if (head == null || head.next == null) {
            return head;
        }

        // 前驱节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        // 后继节点
        ListNode next = head;

        // 改变链表指向
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 链表合并
     * @param l1
     * @param l2
     */
    private void mergeTwo(ListNode l1, ListNode l2) {

        // 用于记录链表的下一节点
        ListNode l1_next, l2_next;

        // 合并
        while (l1 != null && l2 != null) {
            l1_next = l1.next;
            l2_next = l2.next;

            l1.next = l2;
            l1 = l1_next;

            l2.next = l1;
            l2 = l2_next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
