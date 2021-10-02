/**
<p>给你一个字符串&nbsp;<code>columnTitle</code> ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。</p>

<p>&nbsp;</p>

<p>例如，</p>

<pre>
    A -&gt; 1
    B -&gt; 2
    C -&gt; 3
    ...
    Z -&gt; 26
    AA -&gt; 27
    AB -&gt; 28 
    ...
</pre>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> columnTitle = "A"
<strong>输出:</strong> 1
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入: </strong>columnTitle = "AB"
<strong>输出:</strong> 28
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>
<strong>输入: </strong>columnTitle = "ZY"
<strong>输出:</strong> 701</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入: </strong>columnTitle = "FXSHRXW"
<strong>输出: </strong>2147483647
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
	<li><code>columnTitle</code> 仅由大写英文组成</li>
	<li><code>columnTitle</code> 在范围 <code>["A", "FXSHRXW"]</code> 内</li>
</ul>
<div><li>👍 287</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {

		int res = 0;

		int n = columnTitle.length();

		for (int i = 0; i < n; i++) {
			res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
