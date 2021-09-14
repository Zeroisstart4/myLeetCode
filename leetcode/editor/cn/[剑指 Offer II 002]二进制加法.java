/**
<p>给定两个 01 字符串&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>&nbsp;，请计算它们的和，并以二进制字符串的形式输出。</p>

<p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> a = &quot;11&quot;, b = &quot;10&quot;
<strong>输出:</strong> &quot;101&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
<strong>输出:</strong> &quot;10101&quot;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
	<li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
	<li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 67&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-binary/">https://leetcode-cn.com/problems/add-binary/</a></p>
<div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 2</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {

		// 结果值
		StringBuilder res = new StringBuilder();
		// 最大字符长度
		int n = Math.max(a.length(), b.length());
		// 进位值
		int carray = 0;

		for (int i = 0; i < n; i++) {
			// 进位
			carray += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			carray += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
			// 添加元素
			res.append((char) (carray % 2 + '0'));
			// 进位值 / 2
			carray /= 2;
		}

		// 若仍有进位，添加
		if (carray > 0) {
			res.append(carray);
		}

		// 反转结果
		res.reverse();

		return res.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)
