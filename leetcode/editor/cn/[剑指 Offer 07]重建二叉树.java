//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 429 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    首先了解：
    前序遍历的形式 : [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    中序遍历的形式 : [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
*/
class Solution {

    // 由于需要在另一个方法中用到前序遍历数组，故将其共享
    private int[] preorder;
    // 创建字典，用于通过的数组元素值查找其对应的索引
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 共享前序遍历数组
        this.preorder = preorder;

        // 将中序遍历数组添加入 inMap， 键为数组的元素值 inorder[i]，值为数组的索引 i
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    /**
     * 递归添加树节点
     * @param root  根节点元素在前序遍历数组中对应的索引值
     * @param left  该树左边界在中序遍历中的对应的索引值
     * @param right 该树右边界在中序遍历中的对应的索引值
     * @return
     */
    TreeNode recur(int root, int left, int right) {

        // 递归中止条件，若树的左边界比右边界大，则返回空
        if(left > right) {
            return null;
        }
        // 创建树的根节点
        TreeNode newRoot = new TreeNode(preorder[root]);
        // 查找根节点在中序遍历中对应的索引
        Integer i = inMap.get(preorder[root]);
        // 递归创建左子节树
        newRoot.left = recur(root + 1, left, i - 1);
        // 递归创建右子节树
        newRoot.right = recur(root + i - left + 1, i + 1, right);
        // 返回树的根节点
        return newRoot;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
