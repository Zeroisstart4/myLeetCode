//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1126 👎 0


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
    // 归并排序合并两链表
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    // 归并排序
    public ListNode sort(ListNode head, ListNode tail) {
        // 递归中止条件：起点为空，或者不可再进行拆分，
        if(head == null) {
            return head;
        }

        if(head.next == tail) {
            head.next = null;
            return head;
        }

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 将链表二分
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) {
                fast = fast.next;
            }
        }

        // 设置中心节点，用于归并排序的拆分
        ListNode mid = slow;
        // 递归排序左子链表
        ListNode list1 = sort(head, mid);
        // 递归排序右子链表
        ListNode list2 = sort(mid, tail);

        // 归并排序合并步，将左右子链表合并
        ListNode sorted = merge(list1, list2);

        return sorted;

    }

    public ListNode merge(ListNode l1, ListNode l2) {

        // 设置哑节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 左右链表都不为空时，选择较小节点值优先添加
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        // 添加剩余节点
        cur.next = (l2 == null ? l1 : l2);

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
