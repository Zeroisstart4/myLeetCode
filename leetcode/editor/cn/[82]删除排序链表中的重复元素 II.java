//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
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
// 👍 595 👎 0


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
        // 若链表为空，则没有删除的必要
        if(head == null) {
            return head;
        }
        // 设置哑节点
        ListNode dummy = new ListNode(0, head);
        // 设置移动指针
        ListNode cur = dummy;
        // 保证链表至少有两个以上元素（哑节点不计入内）
        while (cur.next != null && cur.next.next != null) {

            if(cur.next.val == cur.next.next.val) {
                int duplicate = cur.next.val;
                while (cur.next != null && cur.next.val == duplicate) {
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }

        return dummy.next;

    }
    */

    // 递归法
    public ListNode deleteDuplicates(ListNode head) {

        // 若链表长度小于等于 1 ，不可能发生重复，直接返回
        if(head == null || head.next == null) {
            return head;
        }
        // 进行所有链表后续节点都需要进行的操作
        // 若链表头节点的值与相邻值相等
        if(head.val == head.next.val) {
            // 若发生连续节点的值相同的情况，则将头节点后移一位，直到移动至最后一个重复节点为止
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // 重复节点没有资格作为头节点，故以重复节点的下一位作为头节点
            // 调用递归，执行相同的操作，返回结果
            return deleteDuplicates(head.next);
        }
        // 若链表头节点的值与相邻值不相等，则有资格作为头节点
        else {
            // 进行链表重构，在头节点后拼接上不重复的、以 head.next 作为头节点（若发生头节点连续，会被删除）的后续链表
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
