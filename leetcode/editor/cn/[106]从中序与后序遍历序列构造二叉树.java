//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 497 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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

    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorder = postorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right) {

        if(left > right) {
            return null;
        }
        if(root < 0) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[root]);

        Integer i = map.get(postorder[root]);

        node.right = recur(root - 1, i + 1, right);

        node.left = recur(root - (right - i + 1), left, i - 1);

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
