//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 571 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    //List<Integer> res = new ArrayList<>();
    // 递归式
    /*public List<Integer> preorderTraversal(TreeNode root) {
        // 边界条件判断
        if(root == null) {
            return res;
        }
        // 添加父节点的值
        res.add(root.val);
        // 递归左子树
        preorderTraversal(root.left);
        // 递归右子树
        preorderTraversal(root.right);

        return res;
    }*/

    // 非递归式
    /*public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                res.add(node.val);
                stack.add(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }

        return res;
    }*/

    /*public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode cur = root;

        while (cur != null) {

            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    //输出当前节点
                    res.add(cur.val);
                    //找到当前节点的前驱节点
                    temp.right = cur;
                    cur = cur.left;
                }
                else {
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }*/


    public List<Integer> preorderTraversal(TreeNode root) {

        // 结果集合
        List<Integer> res = new ArrayList<>();
        // 健壮性判断
        if (root == null) {
            return res;
        }

        // 当前节点
        TreeNode cur = root;
        // 遍历二叉树
        while (cur != null) {

            // 若无左子树
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            // 若有左子树
            else {

                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 若未进行线索化二叉树
                if (pre.right == null) {
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
                // 若已进行线索化二叉树
                else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
