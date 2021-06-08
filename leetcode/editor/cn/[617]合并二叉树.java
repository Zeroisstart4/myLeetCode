//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 690 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
    // DFS
    /*public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果两个节点都为空，直接返回空就行了
        if(root1 == null && root2 == null) {
            return null;
        }
        //如果t1节点为空，就返回t2节点
        if(root1 == null) {
            return root2;
        }
        //如果t2节点为空，就返回t1节点
        if(root2 == null) {
            return root1;
        }

        TreeNode newNode = new TreeNode(root1.val + root2.val);

        //当前节点t1和t2合并完之后，还要继续合并t1和t2的子节点
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);

        return newNode;
    }*/

    // BFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果t1节点为空，就返回t2节点
        if(root1 == null) {
            return root2;
        }
        //如果t2节点为空，就返回t1节点
        if(root2 == null) {
            return root1;
        }
        //队列中两棵树的节点同时存在，
        Queue<TreeNode> queue = new LinkedList<>();
        //把这两棵树的节点同时入队
        queue.add(root1);
        queue.add(root2);

        while (!queue.isEmpty()) {
            //两棵树的节点同时出队
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            //把这两个节点的值相加，然后合并到第1棵树的节点上
            node1.val += node2.val;

            if(node1.left == null) {
                //如果node1左子节点为空，我们直接让node2的
                //左子结点成为node1的左子结点，
                node1.left = node2.left;
            }
            else {
                //执行到这一步，说明node1的左子节点不为空，
                //如果node2的左子节点为空就不需要合并了，
                //只有node2的左子节点不为空的时候才需要合并
                if(node2.left != null) {
                    queue.add(node1.left);
                    queue.add(node2.left);
                }
            }

            //原理同上，上面判断的是左子节点，这里判断的是右子节点
            if(node1.right == null) {
                node1.right = node2.right;
            }
            else {
                if(node2.right != null) {
                    queue.add(node1.right);
                    queue.add(node2.right);
                }
            }
        }
        //把第2棵树合并到第1棵树上，所以返回的是第1棵树
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
