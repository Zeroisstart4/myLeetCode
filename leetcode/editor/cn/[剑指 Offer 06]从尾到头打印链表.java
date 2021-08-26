//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 辅助栈法
    /*
    public int[] reversePrint(ListNode head) {
        // 创建辅助栈
        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop().val;
        }

        return arr;
    }
    */


    // 递归法
    public ArrayList<Integer> arr = new ArrayList<>();
    public int[] reversePrint(ListNode head) {

        // 开始递归
        recur(head);
        // 结果数组
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    // 递归方法
    void recur(ListNode head) {
        // 递归中止条件
        if(head == null) {
            return;
        }
        // 开始递归
        recur(head.next);

        // 将链表元素加入数组
        arr.add(head.val);
    }


/*    public int[] reversePrint(ListNode head) {

        recur(head);

        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }

    void recur(ListNode head) {
        if (head == null) {
            return;
        }

        recur(head.next);
        arr.add(head.val);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
