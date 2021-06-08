//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 深度优先搜索 
// 👍 765 👎 0


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
    public TreeNode sortedArrayToBST(int[] nums) {

        //边界条件判断
        if(nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 将有序数组转换为二叉搜索树
     * @param nums      有序数组
     * @param start     起始索引
     * @param end       中止索引
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        //边界条件判断
        if(start > end) {
            return null;
        }

        int mid = (start + end) >> 1;
        //取中间值作为当前节点
        TreeNode root = new TreeNode(nums[mid]);
        //然后递归的方式，中间值之前的是当前节点左子树的所有节点
        root.left = sortedArrayToBST(nums, start, mid - 1);
        //中间值之后的是当前节点的右子树的所有节点
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
