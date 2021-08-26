//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 331 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 用于存储父子节点关系
    Map<Integer, TreeNode> parents = new HashMap<>();
    // 结果集合
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        findParents(root);
        findRes(target, null, 0, k);
        return res;
    }

    /**
     * 构建父子节点关系
     * @param node
     */
    public void findParents(TreeNode node) {

        // 以子节点的值为键，父节点为值，构建 map
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }

        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    /**
     * 查找结果
     * @param node
     * @param from
     * @param depth
     * @param k
     */
    public void findRes(TreeNode node, TreeNode from, int depth, int k) {

        // 健壮性判断
        if (node == null) {
            return;
        }

        // 递归中止条件
        if (depth == k) {
            res.add(node.val);
            return;
        }

        // 剪枝
        // 若左子节点不是上一个起始点
        if (node.left != from) {
            findRes(node.left, node, depth + 1, k);
        }
        // 若右子节点不是上一个起始点
        if (node.right != from) {
            findRes(node.right, node, depth + 1, k);
        }
        // 若父子节点不是上一个起始点
        if (parents.get(node.val) != from) {
            findRes(parents.get(node.val), node, depth + 1, k);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
