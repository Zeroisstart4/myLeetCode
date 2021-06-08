//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {

        // 若根节点为空，
        if(root == null) {
            return new int[0];
        }

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 结果数组
        ArrayList<Integer> ans = new ArrayList<>();
        // 将根节点添加入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            // 取出队列首位
            TreeNode node = queue.poll();
            // 将该节点的值添加入队列
            ans.add(node.val);

            // 若当前节点的左节点不为空
            if(node.left != null) {
                queue.add(node.left);
            }
            // 若当前节点的右节点不为空
            if(node.right != null) {
                queue.add(node.right);
            }
        }

        // 将数组由 list 转为普通数组
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
