import java.util.Stack;

/**
<p>给定一个整数数组 <code>asteroids</code>，表示在同一行的小行星。</p>

<p>对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。</p>

<p>找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [5,10,-5]
<strong>输出：</strong>[5,10]
<b>解释：</b>10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [8,-8]
<strong>输出：</strong>[]
<b>解释：</b>8 和 -8 碰撞后，两者都发生爆炸。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [10,2,-5]
<strong>输出：</strong>[10]
<b>解释：</b>2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [-2,-1,1,2]
<strong>输出：</strong>[-2,-1,1,2]
<b>解释</b><strong>：</strong>-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 </pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= asteroids.length&nbsp;&lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
	<li><code>asteroids[i] != 0</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 735&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/asteroid-collision/">https://leetcode-cn.com/problems/asteroid-collision/</a></p>
<div><div>Related Topics</div><div><li>栈</li><li>数组</li></div></div><br><div><li>👍 1</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {

		// 创建栈
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {
			// 当前行星是否会毁灭
			boolean flag = true;
			// 若两颗行星相向而行，则会发生碰撞
			while (!stack.isEmpty() && asteroids[i] * stack.peek() < 0) {

				// 若 asteroids[i] 比栈顶行星大， 则毁灭栈顶行星，弹出栈顶行星
				if (asteroids[i] < 0 && Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
					stack.pop();
				}
				// 若 asteroids[i] 比栈顶行星小， 则毁灭 asteroids[i]，flag 置为 false，表示不将 asteroids[i] 加入栈
				else if (asteroids[i] < 0 && Math.abs(asteroids[i]) < Math.abs(stack.peek())) {
					flag = false;
					break;
				}
				// 若 asteroids[i] 比栈顶行星相等， 则毁灭 asteroids[i] 与栈顶行星，flag 置为 false，表示不将 asteroids[i] 加入栈
				else if (asteroids[i] < 0 && Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
					stack.pop();
					flag = false;
					break;
				}
				else {
					break;
				}
			}

			if (flag) {
				stack.push(asteroids[i]);
			}
		}

		int[] res = new int[stack.size()];

		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
