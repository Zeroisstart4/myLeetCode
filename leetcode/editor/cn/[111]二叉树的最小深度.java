//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 508 👎 0


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
    /*public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int mindepth = Integer.MAX_VALUE;

        if(root.left != null) {
            mindepth = Math.min(mindepth, minDepth(root.left));
        }
        if(root.right != null) {
            mindepth = Math.min(mindepth, minDepth(root.right));
        }

        return mindepth + 1;
    }*/

    public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                // 判断是否到达终点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                // 将 cur 的相邻节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
