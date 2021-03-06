//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 150 👎 0


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
class Solution {
    // 自顶向下
    /*public boolean isBalanced(TreeNode root) {

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
    }*/

    // 自底向上
    public boolean isBalanced(TreeNode root) {

        return height(root) >= 0;
    }

    /**
     *  树高度
     * @param root
     * @return
     */
    public int height(TreeNode root) {

        // 健壮性判断
        if(root == null) {
            return 0;
        }
        // 左子树高度
        int leftHeight = height(root.left);
        // 右子树高度
        int rightHeight = height(root.right);

        // 若左子树高度或右子树高度为 -1，或者左右子树高度差大于 1
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



}
//leetcode submit region end(Prohibit modification and deletion)
