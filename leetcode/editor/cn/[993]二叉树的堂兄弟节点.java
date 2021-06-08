//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 149 👎 0


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

    int x;
    int xDepth;
    TreeNode xParent;
    boolean xFound;

    int y;
    int yDepth;
    TreeNode yParent;
    boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {

        // 共享 x,y
        this.x = x;
        this.y = y;

        // 深度优先遍历
        dfs(root, 0, null);

        // 深度相同，父节点不同
        return xDepth == yDepth && xParent != yParent;

    }

    /**
     * 深度优先遍历
     * @param node      当前节点
     * @param depth     当前节点深度
     * @param parent    父节点
     */
    public void dfs(TreeNode node, int depth, TreeNode parent) {

        // 若当前节点为空，直接返回
        if(node == null) {
            return;
        }

        // 若当前节点的值等于 x，表示已经找到 x 节点，则为其深度、父节点、是否已搜索到等属性进行赋值
        if(node.val == x) {
            xDepth = depth;
            xParent = parent;
            xFound = true;
        }
        // 若当前节点的值等于 y，表示已经找到 y 节点，则为其深度、父节点、是否已搜索到等属性进行赋值
        if(node.val == y) {
            yDepth = depth;
            yParent = parent;
            yFound = true;
        }

        // 查询是否已经找到节点 x 与节点 y
        if(xFound && yFound) {
            return;
        }

        // 遍历优先左子树
        dfs(node.left, depth + 1, node);

        // 查询是否已经找到节点 x 与节点 y
        if(xFound && yFound) {
            return;
        }

        // 遍历优先右子树
        dfs(node.right, depth + 1, node);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
