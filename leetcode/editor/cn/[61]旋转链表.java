//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 496 👎 0


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
    public ListNode rotateRight(ListNode head, int k) {
        // 若移动位数为 0 ， 或者链表为空，  或者链表仅有一个元素时，直接返回
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        
        int add = n - k % n;
        if(add == n) {
            return head;
        }
        
        cur.next = head;
        
        while(add > 0) {
            cur = cur.next;
            add--;
        }
        
        ListNode res = cur.next;
        cur.next = null;
        
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
