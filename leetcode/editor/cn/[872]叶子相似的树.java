//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,nul
//l,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1]
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：root1 = [1], root2 = [2]
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：root1 = [1,2], root2 = [2,2]
//输出：true
// 
//
// 示例 5： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树可能会有 1 到 200 个结点。 
// 给定的两棵树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        // 保存 root1 的叶子节点值
        ArrayList<Integer> list1 = new ArrayList<>();
        // 保存 root2 的叶子节点值
        ArrayList<Integer> list2 = new ArrayList<>();

        // 深度优先遍历
        dfs(root1, list1);
        dfs(root2, list2);

        // 比较两数组的元素
        if(list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                // 若存在不相同元素，返回 false
                if(!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            // 若不存在不相同元素，返回 true
            return true;
        }
        // 若结果数组长度不同，返回 false
        return false;
    }

    /**
     * 深度优先
     * @param root      树的根节点
     * @param arr       结果数组
     */
    public void dfs(TreeNode root, ArrayList<Integer> arr) {

        // 若为空树，直接中止
        if(root == null) {
            return;
        }
        // 若为叶子节点，添加入数组
        if(root.left == null && root.right == null) {
            arr.add(root.val);
        }
        // 若不为叶子节点，递归
        if(root.left != null) {
            dfs(root.left, arr);
        }
        if(root.right != null) {
            dfs(root.right, arr);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
