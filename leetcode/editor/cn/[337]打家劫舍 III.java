//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 864 👎 0


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
    public int rob(TreeNode root) {

        int[] robHelp = robHelper(root);

        return Math.max(robHelp[0], robHelp[1]);
    }

    /**
     *      计算偷与不偷 root 节点所能获取的最大值
     * @param root
     * @return  返回一个 1 * 2 的数组，
     *          res[0] 表示不偷 root 节点所能获取的最大值
     *          res[1] 表示偷 root 节点所能获取的最大值
     */
    public int[] robHelper(TreeNode root) {

        // 健壮性判断
        if (root == null) {
            return new int[2];
        }

        // 递归左右子树，获取最大值
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        // 不偷 root 节点所能获取的最大值
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷 root 节点所能获取的最大值
        int selected = root.val + left[0] + right[0];

        return new int[]{notSelected, selected};
    }

}
//leetcode submit region end(Prohibit modification and deletion)
