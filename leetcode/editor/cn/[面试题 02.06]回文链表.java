//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 63 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 双指针，转为数组比较
    /*public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {

            if(!arr.get(left).equals(arr.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }*/

    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return check(head);
    }

    public boolean check(ListNode cur) {

        // 递归中止条件
        if(cur != null) {
            // 隐式将链表压入栈中
            if(!check(cur.next)) {
                return false;
            }
            // 首尾元素比较
            if(front.val != cur.val) {
                return false;
            }
            // 左指针后移一位，操作数栈中元素弹出一位
            front = front.next;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
