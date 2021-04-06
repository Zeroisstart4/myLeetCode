//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 二分查找 
// 👍 373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.LinkedList;

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

    // 递归法
    /*
    public int kthSmallest(TreeNode root, int k) {
        // 构建有序数组
        ArrayList<Integer> arr = inOrder(root, new ArrayList<>());
        // 找其中第 k 个最小元素（从 1 开始计数）
        return arr.get(k-1);
    }

    // 中序遍历，构建有序数组
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        // 中序遍历的中止条件
        if(root == null) {
            return arr;
        }
        // 递归中序遍历左子树
        inOrder(root.left, arr);
        // 添加 root 节点
        arr.add(root.val);
        // 递归中序遍历右子树
        inOrder(root.right, arr);
        // 返回 arr
        return arr;
    }
    */

    // 迭代法
    public int kthSmallest(TreeNode root, int k) {
        // 创建结果栈
        LinkedList<TreeNode> stack = new LinkedList<>();

        // 本质是一个中序遍历添加 BST 元素的过程
        while(true) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
