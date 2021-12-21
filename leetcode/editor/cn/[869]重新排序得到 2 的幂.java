import java.util.HashSet;
import java.util.Set;

/**
<p>给定正整数 <code>N</code>&nbsp;，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。</p>

<p>如果我们可以通过上述方式得到&nbsp;2 的幂，返回 <code>true</code>；否则，返回 <code>false</code>。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>1
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>10
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>16
<strong>输出：</strong>true
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>24
<strong>输出：</strong>false
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>46
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= N &lt;= 10^9</code></li>
</ol>
<div><li>👍 122</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Set<String> stringSet = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {

        init();
        return stringSet.contains(countDigits(n));
    }

    public void init() {
        for (int i = 1; i <= 1e9; i <<= 1) {
            stringSet.add(countDigits(i));
        }
    }

    public String countDigits(int n) {

        char[] count = new char[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        return new String(count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
