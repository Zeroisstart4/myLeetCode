//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 116 👎 0


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
    // 迭代法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 设置哑节点
        ListNode dummy = new ListNode(0);
        // 当前节点
        ListNode cur = dummy;
        // 若 l1、l2 都不为空时
        while (l1 != null && l2 != null) {
            // 若 l1 节点的值小于等于 l2 节点的值
            if(l1.val <= l2.val) {
                // 将当前节点 cur 指向 l1
                cur.next = l1;
                // l1 后移一位
                l1 = l1.next;
                // 当前节点后移一位
                cur = cur.next;
            }
            // 若 l1 节点的值大于 l2 节点的值
            else {
                // // 将当前节点 cur 指向 l2
                cur.next = l2;
                // l2 后移一位
                l2 = l2.next;
                // 当前节点后移一位
                cur = cur.next;
            }
        }

        // 将当前节点 cur 指向不为空的节点
        cur.next = (l2 == null ? l1 : l2);

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
