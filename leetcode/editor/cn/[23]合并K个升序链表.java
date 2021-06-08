//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1239 👎 0


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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        if(left > right) {
            return null;
        }

        // 中间值
        int mid = left + ((right - left) >> 1);

        // 关键，采用分治思想对链表进行合并
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }


    // 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        // 设置哑节点
        ListNode dummy = new ListNode();
        // 设置遍历节点
        ListNode cur = dummy;

        // 在两大链表都不为空时添加元素(若题目要求不可破坏原链表结构，则需要进行复制新链表操作)
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 记得每添加一个节点，就使当前节点后移一位
            cur = cur.next;
        }

        // 在两个链表中的一个为空后，会跳出 while 循环，继续拼接未置空的链表
        cur.next = (l1 != null ? l1 : l2);

        return dummy.next;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
