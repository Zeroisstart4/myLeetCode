//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 73 👎 0


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
    // 模拟
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 求和进位
        int carry = 0;
        // 新链表头尾指针
        ListNode head = null, tail = null;
        // 遍历链表
        while (l1 != null || l2 != null) {
            // 获取数值，若为空则以 0 代替
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            // 求和 = 两数相加 + 进位
            int sum = n1 + n2 + carry;

            // 若头节点为空，对头节点与尾节点赋值
            if(head == null) {
                head = tail = new ListNode(sum % 10);
            }
            // 若头节点不为空，在尾节点后添加数值
            else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 计算进位值
            carry = sum / 10;

            // 链表后移一位
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        // 若进位不为 0， 则需将添加至尾节点
        tail.next = carry == 0 ? null : new ListNode(carry);

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
