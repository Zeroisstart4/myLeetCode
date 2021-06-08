//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 深度优先搜索 
// 👍 88 👎 0


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
    public TreeNode sortedArrayToBST(int[] nums) {

        // 健壮性判断
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 构建 BST
     * @param nums      有序数组
     * @param left      左边界
     * @param right     右边界
     * @return
     */
    public TreeNode buildBST(int[] nums, int left, int right) {
        // 递归中止条件
        if(left > right) {
            return null;
        }

        // 计算中间值
        int mid = (left + right) / 2;

        // 根节点
        TreeNode root = new TreeNode(nums[mid]);

        // 递归左子树
        root.left = buildBST(nums, left, mid - 1);
        // 递归右子树
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
