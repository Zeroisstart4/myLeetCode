//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;
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
    // DFS
    /*public int maxDepth(TreeNode root) {

        // 健壮性判断
        if (root == null) {
            return 0;
        }
        // 父树的最大深度 = 左右子树的最大深度 + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/

    // BFS
    public int maxDepth(TreeNode root) {

        // 健壮性判断
        if(root == null) {
            return 0;
        }
        // 节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队列
        queue.offer(root);
        // 统计树的层数
        int count = 0;
        // 遍历
        while (!queue.isEmpty()) {
            // 获取队列的长度，即每层树的节点个数
            int size = queue.size();
            // 遍历
            for (int i = 0; i < size; i++) {
                // 首节点出队列
                TreeNode node = queue.poll();
                // 添加左右子节点
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 每遍历一层，树的层数 + 1
            count++;
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
