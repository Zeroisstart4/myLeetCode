/**
<p>完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 <code>n</code> 层有 <code>2<sup>n-1</sup></code>&nbsp;个节点）的，并且所有的节点都尽可能地集中在左侧。</p>

<p>设计一个用完全二叉树初始化的数据结构&nbsp;<code>CBTInserter</code>，它支持以下几种操作：</p>

<ul>
	<li><code>CBTInserter(TreeNode root)</code>&nbsp;使用根节点为&nbsp;<code>root</code>&nbsp;的给定树初始化该数据结构；</li>
	<li><code>CBTInserter.insert(int v)</code>&nbsp; 向树中插入一个新节点，节点类型为 <code>TreeNode</code>，值为 <code>v</code> 。使树保持完全二叉树的状态，<strong>并返回插入的新节点的父节点的值</strong>；</li>
	<li><code>CBTInserter.get_root()</code> 将返回树的根节点。</li>
</ul>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1]],[2],[]]
<strong>输出：</strong>[null,1,[1,2]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>inputs = [&quot;CBTInserter&quot;,&quot;insert&quot;,&quot;insert&quot;,&quot;get_root&quot;], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
<strong>输出：</strong>[null,3,4,[1,2,3,4,5,6,7,8]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>最初给定的树是完全二叉树，且包含&nbsp;<code>1</code>&nbsp;到&nbsp;<code>1000</code>&nbsp;个节点。</li>
	<li>每个测试用例最多调用&nbsp;<code>CBTInserter.insert</code>&nbsp; 操作&nbsp;<code>10000</code>&nbsp;次。</li>
	<li>给定节点或插入节点的每个值都在&nbsp;<code>0</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;之间。</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 919&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/complete-binary-tree-inserter/">https://leetcode-cn.com/problems/complete-binary-tree-inserter/</a></p>
<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>设计</li><li>二叉树</li></div></div><br><div><li>👍 0</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
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
class CBTInserter {

    // 共享根节点
    TreeNode root;
    // 双端队列，用于存储 非完全节点
    Deque<TreeNode> deque = new LinkedList<>();
    public CBTInserter(TreeNode root) {

        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            // 若该节点为非完全节点，则加入双端队列
            if (node.left == null || node.right == null) {
                deque.add(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    
    public int insert(int v) {
        // 获取队头元素
        TreeNode node = deque.peekFirst();
        // 待插入节点
        TreeNode insertNode = new TreeNode(v);
        // 将待插入节点加入双端队列
        deque.add(insertNode);
        // 插入节点
        if (node.left == null) {
            node.left = insertNode;
        }
        else {
            node.right = insertNode;
            // 若待插入节点为 node 的右子节点，则 node 节点将成为完全节点，需从队列中移除
            deque.pollFirst();
        }

        return node.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)
