/**
<p>有一个密钥字符串 S ，只包含字母，数字以及 &#39;-&#39;（破折号）。其中， N 个 &#39;-&#39; 将字符串分成了 N+1 组。</p>

<p>给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 &#39;-&#39;（破折号）隔开，并且将所有的小写字母转换为大写字母。</p>

<p>给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>S = &quot;5F3Z-2e-9-w&quot;, K = 4
<strong>输出：</strong>&quot;5F3Z-2E9W&quot;
<strong>解释：</strong>字符串 S 被分成了两个部分，每部分 4 个字符；
&nbsp;    注意，两个额外的破折号需要删掉。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>S = &quot;2-5g-3-J&quot;, K = 2
<strong>输出：</strong>&quot;2-5G-3J&quot;
<strong>解释：</strong>字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ol>
	<li>S 的长度可能很长，请按需分配大小。K 为正整数。</li>
	<li>S 只包含字母数字（a-z，A-Z，0-9）以及破折号&#39;-&#39;</li>
	<li>S 非空</li>
</ol>

<p>&nbsp;</p>
<div><li>👍 76</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String licenseKeyFormatting(String s, int k) {

		String str = s.replace("-", "").toUpperCase();
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
			count++;
			if (count % k == 0 && i != 0) {
				sb.append("-");
			}
		}

		return sb.reverse().toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)
