//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 526 👎 0


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
    // 迭代法
    /*
    public ListNode deleteDuplicates(ListNode head) {
        // 若链表为空，直接返回
        if(head == null) {
            return head;
        }
        // 定义一个 cur 指针, 起始位置为 head 节点
        ListNode cur = head;
        // 当 cur 指针指向的下一位不为空时
        while (cur.next != null) {
            // 判断 cur 与其下一位 cur.next 的值是否相等
            if(cur.val == cur.next.val) {
                // 是，则将删除 cur.next, 实现方式为越过 cur.next
                cur.next = cur.next.next;
            }
            // 若不相等
            else {
                // cur 后移一位
                cur = cur.next;
            }
        }
        return head;
    }
    */

    // 递归法
    // 递归的关键在与提取各个节点间操作的共性，通过递归进行规模的缩减
    public ListNode deleteDuplicates(ListNode head) {

        // 若链表至多只有一个元素，则不可能发生重复，直接返回
        if(head == null || head.next == null) {
            return head;
        }
        // 若头节点与后继节点发生重复，则将后继节点定义为新的头节点，递归调用 deleteDuplicates
        if(head.val == head.next.val) {
            head = head.next;
            return deleteDuplicates(head);
        }
        // 若头节点与后继节点不重复，则进行链表重构，将头节点指向以后继节点为头节点，进行过删除重复元素的操作的链表
        else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
