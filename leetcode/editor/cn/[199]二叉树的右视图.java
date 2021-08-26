//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 513 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        // 每层的最右节点，键为 depth, 值为 node.val
        Map<Integer, Integer> mostRightValOfPerLayer = new HashMap<Integer, Integer>();

        // 维护一个最大层数
        int maxDepth = -1;

        // 节点队列，用于存入每层的节点
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        // 深度队列，用于存入每层的节点对应的深度
        Queue<Integer> depthQueue = new LinkedList<>();

        // 将根节点信息存入对应队列
        nodeQueue.offer(root);
        depthQueue.offer(0);

        // 遍历
        while (!nodeQueue.isEmpty()) {
            // 取出节点队列与深度的的头节点
            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();

            // 健壮性判断
            if (node != null) {

                // 维护最大深度
                maxDepth = Math.max(maxDepth, depth);
                // 最右节点存入 map
                mostRightValOfPerLayer.put(depth, node.val);

                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);

                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++){
            res.add(mostRightValOfPerLayer.get(depth));
        }

        return res;
    }

    /*public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxDepth = 0;

        nodeQueue.offer(root);
        depthQueue.offer(0);

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();

            if (node != null) {

                maxDepth = Math.max(maxDepth, depth);
                map.put(depth, node.val);

                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);

                nodeQueue.offer(node.rihgt);
                depthQueue.offer(depth + 1);
            }
        }

        for (int i = 0; i <= maxDepth; i++) {
            res.add(map.get(i));
        }

        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
