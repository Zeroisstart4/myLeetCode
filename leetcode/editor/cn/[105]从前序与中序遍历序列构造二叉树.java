//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1028 👎 0


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

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right) {

        if(left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[root]);

        Integer i = map.get(preorder[root]);

        node.left = recur(root + 1, left, i - 1);

        node.right = recur(root + i - left + 1, i + 1, right);

        return node;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
