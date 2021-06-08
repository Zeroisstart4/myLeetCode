//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7] 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
// Related Topics 树 深度优先搜索 
// 👍 67 👎 0


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
    // DFS
    // 统计次数
    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        // 若树为空，则无可达路径
        if(root == null) {
            return 0;
        }
        dfs(root, 0, sum);
        // 递归左右子树
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return count;
    }

    /**
     * 统计当前树从根节点起的所有可达路径
     * @param root      根节点
     * @param sum       当前路径所求和
     * @param target    目标值
     */
    public void dfs(TreeNode root, int sum, int target) {
        // 若树为空，直接返回
        if(root == null) {
            return;
        }
        // 若当前路径所求和 + 当前访问节点的值 = 目标值，路径 + 1
        if(sum + root.val == target) {
            count++;
        }

        // 继续走左右子树
        dfs(root.left, sum + root.val, target);
        dfs(root.right, sum + root.val, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
