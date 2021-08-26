//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
    // 递归
    /*
    public TreeNode mirrorTree(TreeNode root) {

        // 若树为空
        if(root == null) {
            return null;
        }

        // 由于发生递归后，会改变原树的顺序，故需记录原树的左节点
        TreeNode temp = root.left;

        // 递归，交换左右子树
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
    */

    // 迭代
    public TreeNode mirrorTree(TreeNode root) {

        // 若树为空
        if(root == null) {
            return null;
        }

        // 用于装填树节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将 root 添加为此列表的尾部（最后一个元素）。
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 检索并删除此列表的头（第一个元素）。
            TreeNode node = queue.poll();

            // 添加左子节点（如果存在）
            if(node.left != null) {
                queue.offer(node.left);
            }
            // 添加右子节点（如果存在）
            if(node.right != null) {
                queue.offer(node.right);
            }

            // 交换节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }


    /*public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
