//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 50 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // BFS
    public ListNode[] listOfDepth(TreeNode tree) {

        // 用来构建返回值
        ArrayList<ListNode> res = new ArrayList<>();
        // 帮助用来层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把树的根节点入队
        queue.offer(tree);

        while (!queue.isEmpty()) {
            // 逐层遍历树
            int size = queue.size();
            // dummy 节点是用来标记链表头节点的辅助节点
            ListNode dummy = new ListNode(0);
            // cur 节点用来逐个连接新节点
            ListNode cur = dummy;

            for (int i = 0; i < size; i++) {
                // 遍历这一层的所有节点
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                // 把这一层所有节点的左右子节点放到队列中去
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 把这一层的链表头放到返回值中
            res.add(dummy.next);

        }

        return res.toArray(new ListNode[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
