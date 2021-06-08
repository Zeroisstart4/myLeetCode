//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 70 👎 0


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
    public int kthToLast(ListNode head, int k) {

        // slow 用来定位倒数第 k 个节点,fast 用来定位最后一个节点
        ListNode fast = head;
        ListNode slow = head;

        // 首先让 fast 和 slow 之间错开 k - 1 个位置
        for (int i = 0; i < k; i++) {
            if(fast != null) {
                fast = fast.next;
            }
            else {
                return 0;
            }
        }

        // 然后一起往链表末尾移动,直到 fast 抵达最后一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 返回 slow 指向的节点数据
        return slow.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
