/**
<p>给你一棵二叉搜索树，请&nbsp;<strong>按中序遍历</strong> 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;" /></p>

<pre>
<strong>输入：</strong>root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;" /></p>

<pre>
<strong>输入：</strong>root = [5,1,7]
<strong>输出：</strong>[1,null,5,null,7]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数的取值范围是 <code>[1, 100]</code></li>
	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 897&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">https://leetcode-cn.com/problems/increasing-order-search-tree/</a></p>
<div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    public TreeNode increasingBST(TreeNode root) {

        List<Integer> nodeList = new ArrayList<>();
        inorder(root, nodeList);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;

        for (int val : nodeList) {
            currNode.right = new TreeNode(val);
            currNode = currNode.right;
        }

        return dummyNode.right;
    }

    public void inorder(TreeNode root, List<Integer> nodeList) {

        if (root == null) {
            return;
        }

        inorder(root.left, nodeList);
        nodeList.add(root.val);
        inorder(root.right, nodeList);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
