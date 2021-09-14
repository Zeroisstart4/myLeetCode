/**
<p>给你两个 <strong>非空 </strong>链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>

<p> </p>

<p><strong>示例1：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420025-fZfzMX-image.png" style="width: 302px; " /></p>

<pre>
<strong>输入：</strong>l1 = [7,2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,8,0,7]
</pre>

<p><strong>示例2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[8,0,7]
</pre>

<p><strong>示例3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的长度范围为<code> [1, 100]</code></li>
	<li><code>0 <= node.val <= 9</code></li>
	<li>输入数据保证链表代表的数字无前导 0</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。</p>
<div><div>Related Topics</div><div><li>栈</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 423</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		int carray = 0;
		ListNode res = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carray > 0) {

			int num1 = stack1.isEmpty() ? 0 : stack1.pop();
			int num2 = stack2.isEmpty() ? 0 : stack2.pop();
			int sum = num1 + num2 + carray;
			ListNode cur = new ListNode(sum % 10);
			carray = sum / 10;
			cur.next = res;
			res = cur;
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
