//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 161 👎 0


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

    // 用于共享变量
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {

        this.k = k;
        // 逆序中序遍历，从最大值开始遍历
        dfs(root);

        return res;
    }

    /**
     *  逆序中序遍历
     * @param root      根节点
     */
    public void dfs(TreeNode root) {

        // 健壮性判断
        if(root == null) {
            return;
        }

        // 递归右子树
        dfs(root.right);

        // 根节点
        if(k == 0) {
            return;
        }
        if(--k == 0) {
            res = root.val;
        }
        // 递归左子树
        dfs(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
