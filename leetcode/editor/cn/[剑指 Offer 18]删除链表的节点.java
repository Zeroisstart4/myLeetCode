//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 112 👎 0


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
    public ListNode deleteNode(ListNode head, int val) {
        // 作为哑节点，由于 head 可能需要进行操作，故创建一个新节点作为头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 前驱节点
        ListNode pre = dummy;
        // 当前节点
        ListNode cur = head;
        // 若当前节点不等于目标值，则继续遍历
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 若当前节点等于目标值，则跳过当前节点
        pre.next = cur.next;

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
