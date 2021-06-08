//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 918 👎 0


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
    // 双指针遍历
    /*ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        // 若 right 为空， 返回 true
        if(right == null) {
            return true;
        }
        // 递归
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        // 左节点后移一位
        left = left.next;
        return res;
    }*/

    // 双指针遍历优化（快慢指针）
    /*public boolean isPalindrome(ListNode head) {
        // 快指针
        ListNode slow = head;
        // 慢指针
        ListNode fast = head;
        // 快指针后移两位， 慢指针后移一位
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast指针没有指向null，说明链表长度为奇数
        if(fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);

        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }*/

    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return check(head);
    }

    public boolean check(ListNode head) {

        if(head != null) {

            if(!check(head.next)) {
                return false;
            }

            if(head.val != front.val) {
                return false;
            }

            front = front.next;
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
