//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 503 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        dfs(root, "", res);

        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res) {

        //如果到达叶子节点，就把结果存放到集合res中
        if(root.left == null && root.right == null) {
            res.add(path + root.val);
        }

        //如果左子节点不为空，就沿着左子节点走下去
        if(root.left != null) {
            dfs(root.left, path + root.val + "->", res);
        }

        //如果右子节点不为空，就沿着右子节点走下去
        if(root.right != null) {
            dfs(root.right, path + root.val + "->", res);
        }
    }*/

    // 递归

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        //到达叶子节点，把路径加入到集合中
        if(root.left == null && root.right == null) {
            res.add(root.val + "");
        }

        //遍历左子节点的所有路径
        for (String path : binaryTreePaths(root.left)) {
            res.add(root.val + "->" + path);
        }

        //遍历右子节点的所有路径
        for (String path : binaryTreePaths(root.right)) {
            res.add(root.val + "->" + path);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
