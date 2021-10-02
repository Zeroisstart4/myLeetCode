/**
<p>给你一个 <strong>正</strong> 整数 <code>num</code> ，输出它的补数。补数是对该数的二进制表示取反。</p>

<p> </p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num = 5
<strong>输出：</strong>2
<strong>解释：</strong>5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num = 1
<strong>输出：</strong>0
<strong>解释：</strong>1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>给定的整数 <code>num</code> 保证在 32 位带符号整数的范围内。</li>
	<li><code>num >= 1</code></li>
	<li>你可以假定二进制数不包含前导零位。</li>
	<li>本题与 1009 <a href="https://leetcode-cn.com/problems/complement-of-base-10-integer/">https://leetcode-cn.com/problems/complement-of-base-10-integer/</a> 相同</li>
</ul>
<div><li>👍 225</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {

		int mask = -1;

		while ((mask & num) > 0) {
			mask <<= 1;
		}

		return ~mask ^ num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
