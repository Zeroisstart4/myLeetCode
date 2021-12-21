

/**
<p>给定三个字符串 <code>s1</code>、<code>s2</code>、<code>s3</code>，请你帮忙验证 <code>s3</code> 是否是由 <code>s1</code> 和 <code>s2</code><em> </em><strong>交错 </strong>组成的。</p>

<p>两个字符串 <code>s</code> 和 <code>t</code> <strong>交错</strong> 的定义与过程如下，其中每个字符串都会被分割成若干 <strong>非空</strong> 子字符串：</p>

<ul>
	<li><code>s = s<sub>1</sub> + s<sub>2</sub> + ... + s<sub>n</sub></code></li>
	<li><code>t = t<sub>1</sub> + t<sub>2</sub> + ... + t<sub>m</sub></code></li>
	<li><code>|n - m| <= 1</code></li>
	<li><strong>交错</strong> 是 <code>s<sub>1</sub> + t<sub>1</sub> + s<sub>2</sub> + t<sub>2</sub> + s<sub>3</sub> + t<sub>3</sub> + ...</code> 或者 <code>t<sub>1</sub> + s<sub>1</sub> + t<sub>2</sub> + s<sub>2</sub> + t<sub>3</sub> + s<sub>3</sub> + ...</code></li>
</ul>

<p><strong>提示：</strong><code>a + b</code> 意味着字符串 <code>a</code> 和 <code>b</code> 连接。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/02/interleave.jpg" style="width: 561px; height: 203px;" />
<pre>
<strong>输入：</strong>s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s1 = "", s2 = "", s3 = ""
<strong>输出：</strong>true
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s1.length, s2.length <= 100</code></li>
	<li><code>0 <= s3.length <= 200</code></li>
	<li><code>s1</code>、<code>s2</code>、和 <code>s3</code> 都由小写英文字母组成</li>
</ul>
<div><li>👍 566</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();

		if (len1 + len2 != len3) {
			return false;
		}

		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;

		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {

				int pos = i + j - 1;
				if (i > 0) {
					dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(pos));
				}
				if (j > 0) {
					dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(pos));
				}
			}
		}

		return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
