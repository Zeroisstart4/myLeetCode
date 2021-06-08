//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 
// 👍 61 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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

    // 简单中序遍历
    /*List<TreeNode> res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        res = new ArrayList<>();

        inOrder(root);
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i) == p) {
                return i < res.size() - 1 ? res.get(i + 1) : null;
            }
        }

        return null;
    }

    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        res.add(root);
        inOrder(root.right);
    }*/

    // 利用 BST 的性质
    /*public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode pre = null;

        while (root.val != p.val) {

            if(root.val < p.val) {
                root = root.right;
            }
            else {
                pre = root;
                root = root.left;
            }
        }

        if(root.right == null) {
            return pre;
        }
        else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }*/

    // 递归法
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // 递归中止条件
        if(root == null) {
            return null;
        }

        // 利用 BST 性质，缩小树的规模，若根节点的值小于目标节点值，则目标节点位于右子树中
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        // 若根节点的值大于目标节点值，则目标节点位于左子树中
        else {
            // 获得目标节点的下一个节点
            TreeNode left = inorderSuccessor(root.left, p);

            // 若目标节点的下一个节点为空，表示其不在左子树中，返回根节点
            if(left == null) {
                return root;
            }
            else {
                return left;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
