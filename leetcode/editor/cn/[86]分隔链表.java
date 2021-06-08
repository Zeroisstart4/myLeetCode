//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 401 👎 0


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
    // 四指针
    public ListNode partition(ListNode head, int x) {

        //小链表的头
        ListNode smallHead = new ListNode(0);
        //小链表的尾
        ListNode smallTail = smallHead;
        //大链表的头
        ListNode bigHead = new ListNode(0);
        //大链表的尾
        ListNode bigTail = bigHead;

        //遍历head链表
        while (head != null) {

            //如果当前节点的值小于x，则把当前节点挂到小链表的后面
            if(head.val < x) {
                smallTail = smallTail.next = head;
            }
            //否则挂到大链表的后面
            else {
                bigTail = bigTail.next = head;
            }
            //继续循环下一个结点
            head = head.next;
        }

        //最后再把大小链表拼接在一块即可。
        smallTail.next = bigHead.next;
        bigTail.next = null;

        return smallHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
