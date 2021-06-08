//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 685 👎 0


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
    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        //分别计算左子树和右子树的高度
        int left = depth(root.left);
        int right = depth(root.right);

        //这两个子树的高度不能超过1，并且他的两个子树也必须是平衡二叉树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    //计算树中节点的高度
    public int depth(TreeNode root) {
        // 边界条件
        if(root == null) {
            return 0;
        }

        // 左右子树的最大深度 + 1
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
