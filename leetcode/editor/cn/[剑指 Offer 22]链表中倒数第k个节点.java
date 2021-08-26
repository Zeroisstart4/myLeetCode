//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 187 👎 0


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
    // 二次遍历
    /*
    public ListNode getKthFromEnd(ListNode head, int k) {

        // 链表节点个数
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // 将 cur 重置为头节点
        cur = head;
        // 倒数第 k 个节点对应的是第 （count - k + 1） 个节点；
        for (int i = 1; i < count - k + 1; i++) {
            cur = cur.next;
        }
        return cur;
    }
    */

    // 双指针(快慢指针)
    public ListNode getKthFromEnd(ListNode head, int k) {

        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode low = head;

        // 先使快指针后移 k 位
        for (int i = 0; i < k; i++) {
            if(fast != null) {
                fast = fast.next;
            }
            else {
                return null;
            }
        }
        // 当快指针指向空时，慢指针恰好为链表中倒数第 k 个节点
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }

        return low;
    }

    /*public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
            else {
                return null;
            }
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
