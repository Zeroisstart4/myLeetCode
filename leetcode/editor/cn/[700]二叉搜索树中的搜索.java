//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 
// 👍 122 👎 0


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
    // 充分使用 BST 的特点

    // 递归法
    /*
    public TreeNode searchBST(TreeNode root, int val) {
        // 递归中止条件
        if(root == null || root.val == val) {
            return root;
        }
        // 递归
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
    */

    // 迭代法
    public TreeNode searchBST(TreeNode root, int val) {
       while(root != null && root.val != val) {
           root = val < root.val ? root.left : root.right;
       }
       return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
