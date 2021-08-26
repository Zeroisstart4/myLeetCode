//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 590 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    List<Integer> res = new ArrayList<>();
    // 递归式
    /*public List<Integer> postorderTraversal(TreeNode root) {

        // 边界条件判断
        if(root == null) {
            return res;
        }

        // 递归左子树
        postorderTraversal(root.left);
        // 递归右子树
        postorderTraversal(root.right);
        // 添加父节点的值
        res.add(root.val);

        return res;
    }*/

    // 非递归式
    /*public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        // 通过lastVisit标识右子节点是否已经弹出
        TreeNode lastVisit = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //查看当前栈顶元素
            p = stack.peek();
            //如果其右子树也为空，或者右子树已经访问，则可以访问
            if (p.right == null || p.right == lastVisit) {
                res.add(p.val);
                stack.pop();
                // 标记当前这个节点已经弹出过
                lastVisit = p;
                p = null;
            } else {
                //否则继续遍历右子树
                p = p.right;
            }
        }
        return res;
    }*/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode virNode = new TreeNode(-1);

        virNode.left = root;
        TreeNode cur = virNode;

        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            }
            else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                }
                else {
                    temp.right = null;
                    TreeNode t = cur.left;
                    List<Integer> tempList = new ArrayList<>();
                    while (t != null) {
                        tempList.add(0, t.val);
                        t = t.left;
                    }
                    res.addAll(res);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
