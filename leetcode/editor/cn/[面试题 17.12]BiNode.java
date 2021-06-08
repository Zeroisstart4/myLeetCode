//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 73 👎 0


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
    TreeNode dummy = new TreeNode(0);
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return dummy.right;
    }

    public void inOrder(TreeNode root) {
        // 中止条件
        if(root == null) {
            return;
        }
        // 递归左子树
        inOrder(root.left);

        // 第一个节点
        if(pre == null) {
            dummy.right = root;
            pre = root;
        }
        // 第一个节点之后的节点
        else {
            pre.right = root;
            pre = root;
        }

        root.left = null;

        // 递归右子树
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
