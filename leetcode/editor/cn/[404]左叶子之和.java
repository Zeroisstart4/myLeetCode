/**
<p>计算给定二叉树的所有左叶子之和。</p>

<p><strong>示例：</strong></p>

<pre>
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24</pre>

<p>&nbsp;</p>
<div><li>👍 345</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
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
    public int sumOfLeftLeaves(TreeNode root) {

        return root == null ? 0 : dfs(root);
    }

    public int dfs(TreeNode node) {

        int sum = 0;
        if (node.left != null) {
            sum += isLeaf(node.left) ? node.left.val : dfs(node.left);
        }

        if (node.right != null && !isLeaf(node.right)) {
            sum += dfs(node.right);
        }

        return sum;
    }

    public boolean isLeaf(TreeNode node) {

        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
