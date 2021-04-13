//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 423 👎 0


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
    public TreeNode deleteNode(TreeNode root, int key) {
        // 若根节点为空，直接返回
        if (root == null) {
            return null;
        }
        // 若根节点即为需删除节点
        if (root.val == key) {
            // 若其左子节点为空，则以右子节点作为新的 root 节点
            if (root.left == null) {
                return root.right;
            }
            // 若其右子节点为空，则以左子节点作为新的 root 节点
            if (root.right == null) {
                return root.left;
            }

            // 若左右子节点都存在，则需获取右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 将最小节点的赋给根节点
            root.val = minNode.val;
            // 此时，需要重构右子树，递归删除 minNode 节点
            root.right = deleteNode(root.right, minNode.val);

        }
        // 若根节点不为删除节点，目标节点位于根节点的左侧，重构左子树，递归删除 key 节点
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // 若根节点不为删除节点，目标节点位于根节点的右侧，重构右子树，递归删除 key 节点
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // 获取最小节点
    TreeNode getMin(TreeNode node) {
        // BST 最左子节点就是最小的节点
        while(node.left != null) {
            node = node.left;
        }
        // 若不存在左子节点，最小的节点为根节点
        // 若存在左子节点，最小的节点为最左子节点
        return node;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
