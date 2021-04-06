//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 841 👎 0


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

    // 后继节点
    ListNode successor = null;
    // 反转从 left 到 right 的链表元素
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 健壮性判断，若链表最多只有一个元素，直接返回 head
        if(head == null || head.next == null) {
            return head;
        }
        // 若 left == 1, 调用反转链表的前 n 个元素的方法
        if(left == 1) {
            return reverseN(head, right);
        }
        // 递归
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }

    // 反转链表的前 n 个元素
    public ListNode reverseN(ListNode head, int n) {
        // 健壮性判断，若链表最多只有一个元素，直接返回 head
        if(head == null || head.next == null) {
            return head;
        }
        // 若仅仅反转前一位元素，则记录当前元素的下一位元素，放回当前元素
        // 在这一过程中，“记录当前元素的下一位元素” 似乎显得多余，其实不然
        // successor = head.next 为我们使头节点找到了它所需要指向的目标
        if(n == 1) {
            successor = head.next;
            return head;
        }
        // 递归
        ListNode last = reverseN(head.next, n - 1);
        // 将当前节点的后一位指向当前节点，形成循环链表
        head.next.next = head;
        // 断开循环链表，造成局部反转
        head.next = successor;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
