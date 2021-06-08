//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 105 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 哈希查重
    public ListNode removeDuplicateNodes(ListNode head) {

        // 边界条件判断
        if(head == null || head.next == null) {
            return head;
        }

        // set 查重
        Set<Integer> occurred = new HashSet<>();

        // 前驱与当前节点
        ListNode pre = null;
        ListNode cur = head;

        // 遍历链表
        while (cur != null) {
            // 若未发生重复
            if(occurred.add(cur.val)) {
                // 前驱指针后移一位
                pre = cur;
            }
            // 若发生重复
            else {
                // 前驱节点越过当前节点
                pre.next = cur.next;
            }

            // 无论是否发生重复，当前节点都需后移一位
            cur = cur.next;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
