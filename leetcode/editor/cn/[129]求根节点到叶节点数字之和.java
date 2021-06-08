//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 354 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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

    // DFS
    /*public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {

        //终止条件的判断
        if(root == null) {
            return 0;
        }

        //计算当前节点的值
        sum = sum * 10 + root.val;

        //如果当前节点是叶子节点，说明找到了一条完整路径，直接
        //返回这条路径的值即可
        if(root.left == null && root.right == null) {
            return sum;
        }
        //如果当前节点不是叶子结点，返回左右子节点的路径和
        return dfs(root.left, sum) + dfs(root.right, sum);
    }*/


    // BFS
    public int sumNumbers(TreeNode root) {

        //边界条件的判断
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        int res = 0;
        nodeQueue.add(root);
        valueQueue.add(root.val);

        while (!nodeQueue.isEmpty()) {
            //节点和节点对应的值同时出队
            TreeNode node = nodeQueue.poll();
            Integer value = valueQueue.poll();

            if(node.left == null && node.right == null) {
                //如果当前节点是叶子结点，说明找到了一条路径，把这条
                //路径的值加入到全局变量res中
                res += value;
            }
            else {
                //如果不是叶子节点就执行下面的操作
                if(node.left != null) {
                    //把子节点和子节点的值分别加入到队列中，这里子节点的值
                    //就是父节点的值*10+当前节点的值
                    nodeQueue.add(node.left);
                    valueQueue.add(value * 10 + node.left.val);
                }

                if(node.right != null) {
                    nodeQueue.add(node.right);
                    valueQueue.add(value * 10 + node.right.val);
                }
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
