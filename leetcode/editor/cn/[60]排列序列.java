import java.util.Arrays;

/**
<p>给出集合 <code>[1,2,3,...,n]</code>，其所有元素共有 <code>n!</code> 种排列。</p>

<p>按大小顺序列出所有排列情况，并一一标记，当 <code>n = 3</code> 时, 所有排列如下：</p>

<ol>
	<li><code>"123"</code></li>
	<li><code>"132"</code></li>
	<li><code>"213"</code></li>
	<li><code>"231"</code></li>
	<li><code>"312"</code></li>
	<li><code>"321"</code></li>
</ol>

<p>给定 <code>n</code> 和 <code>k</code>，返回第 <code>k</code> 个排列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3, k = 3
<strong>输出：</strong>"213"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 4, k = 9
<strong>输出：</strong>"2314"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3, k = 1
<strong>输出：</strong>"123"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 9</code></li>
	<li><code>1 <= k <= n!</code></li>
</ul>
<div><li>👍 580</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {

		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		k--;
		StringBuilder sb = new StringBuilder();
		int[] valid = new int[n + 1];
		Arrays.fill(valid, 1);

		for (int i = 1; i <= n; i++) {
			int order = k / factorial[n - i] + 1;
			for (int j = 1; j <= n; j++) {
				order -= valid[j];
				if (order == 0) {
					sb.append(j);
					valid[j] = 0;
					break;
				}
			}
			k %= factorial[n - i];
		}

		return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
