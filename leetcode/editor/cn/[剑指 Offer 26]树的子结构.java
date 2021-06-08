//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 263 👎 0


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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 保证 A、B 树非空，
        // 并判断 A 树是否 B 树的父树（以两树根节点为起点）
        // 递归判断 A 树的左子树是否 B 树的父树
        // 递归判断 A 树的右子树是否 B 树的父树
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    // 判断 A 树是否 B 树的子树（以两树根节点为起点）
    boolean recur(TreeNode A, TreeNode B) {
        // 若 B 树为空，则其为 A 树的子树
        if(B == null) {
            return true;
        }
        // 若 A 树为空，或者 A 树根节点的值不等于 B 树根节点，则 B 树不是 A 树的子树
        if(A == null || A.val != B.val) {
            return false;
        }

        // 进一步比较 A、B 树的左右子树
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
