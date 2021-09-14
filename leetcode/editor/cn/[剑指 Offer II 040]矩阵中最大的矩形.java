import java.util.Stack;

/**
<p>给定一个由&nbsp;<code>0</code> 和 <code>1</code>&nbsp;组成的矩阵 <code>matrix</code>&nbsp;，找出只包含 <code>1</code> 的最大矩形，并返回其面积。</p>

<p><strong>注意：</strong>此题 <code>matrix</code>&nbsp;输入格式为一维 <code>01</code> 字符串数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;" /></p>

<pre>
<strong>输入：</strong>matrix = ["10100","10111","11111","10010"]
<strong>输出：</strong>6
<strong>解释：</strong>最大矩形如上图所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = []
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["0"]
<strong>输出：</strong>0
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["1"]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>matrix = ["00"]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[0].length</code></li>
	<li><code>0 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 85 题相同（输入参数格式不同）：&nbsp;<a href="https://leetcode-cn.com/problems/maximal-rectangle/">https://leetcode-cn.com/problems/maximal-rectangle/</a></p>
<div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>动态规划</li><li>矩阵</li><li>单调栈</li></div></div><br><div><li>👍 2</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(String[] matrix) {

		// 健壮性判断
		if (matrix == null || matrix.length == 0 || matrix[0].length() == 0) {
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length();

		// left[i][j] 表示第 i 行（从 0 开始）， 以 j 为终点的连续 1 个数
		int[][] left = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i].charAt(j) == '1') {
					left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
				}
			}
		}

		int res = 0;
		Stack<Integer> stack = new Stack<>();

		for (int j = 0; j < cols; j++) {

			int[] up = new int[rows];
			int[] down = new int[rows];

			for (int i = 0; i < rows; i++) {

				while (!stack.isEmpty() && left[stack.peek()][j] > left[i][j]) {
					stack.pop();
				}
				up[i] = stack.isEmpty() ? -1 : stack.pop();
				stack.push(i);
			}

			stack.clear();
			for (int i = rows - 1; i >= 0; i--) {

				while (!stack.isEmpty() && left[stack.peek()][j] > left[i][j]) {
					stack.pop();
				}
				down[i] = stack.isEmpty() ? rows : stack.pop();
				stack.push(i);
			}

			for (int i = 0; i < rows; i++) {
				int height = down[i] - up[i] - 1;
				int multi = height * left[i][j];
				res = Math.max(res, multi);
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
