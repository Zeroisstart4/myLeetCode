//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 
// 👍 50 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

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

    // 递归法
    /*public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    *//**
     * 检验树二叉搜索树的合法性
     * @param root      根节点
     * @param min       最小值
     * @param max       最大值
     * @return
     *//*
    public boolean isValidBST(TreeNode root, long min, long max) {

        // 若根节点为空
        if(root == null) {
            return true;
        }
        // 若根节点的值大于最大值或小于最小值
        if(root.val >= max || root.val <= min) {
            return false;
        }
        // 递归，左子节点的范围在（min, root.val）, 右子树的范围在（root.val, max）
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }*/

    // 中序遍历递归版
    /*TreeNode pre;
    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) {
            return false;
        }

        if(pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;

        if(!isValidBST(root.right)) {
            return false;
        }

        return true;
    }*/

    // 中序遍历非递归版
    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(pre != null && pre.val >= root.val) {
                return false;
            }

            pre = root;

            root = root.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
