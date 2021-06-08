//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // DFS
    public int maxDepth(TreeNode root) {

        // 递归中止条件
        if(root == null) {
            return 0;
        }
        // 递归左右子树
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 获取左右子树的最大深度 + 1
        return Math.max(left, right) + 1;
    }


    // BFS
    /*public int maxDepth(TreeNode root) {

        // 若为空树
        if (root == null) {
            return 0;
        }

        // 树的层树
        int level = 0;
        // 设置队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            // 记录每层的节点数
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 添加左右子节点
                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            level++;
        }

        return level;
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)
