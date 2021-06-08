//检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。 
//
// 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。 
//
// 注意：此题相对书上原题略有改动。 
//
// 示例1: 
//
// 
// 输入：t1 = [1, 2, 3], t2 = [2]
// 输出：true
// 
//
// 示例2: 
//
// 
// 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
// 输出：false
// 
//
// 提示： 
//
// 
// 树的节点数目范围为[0, 20000]。 
// 
// Related Topics 树 
// 👍 34 👎 0


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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 空树是任何树的子树
        if(t2 == null) {
            return true;
        }
        // 父树为空，子树不为空
        if(t1 == null) {
            return false;
        }
        // 检查两树是否从根节点开始相同，同时也可检查左右子树
        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    // 检测两树是否相同
    public boolean isSame(TreeNode t1, TreeNode t2) {

        // 若两树有相同的根节点
        if(t1 == t2) {
            return true;
        }
        // 若有且仅有一颗树为空
        if(t1 == null || t2 == null) {
            return false;
        }
        // 检查两树的对应节点值是否相同，并递归检验左右子树
        return (t1.val == t2.val) && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
