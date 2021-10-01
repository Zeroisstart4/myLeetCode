/**
<p>给定一个非负整数 <code>x</code> ，计算并返回 <code>x</code> 的平方根，即实现&nbsp;<code>int sqrt(int x)</code>&nbsp;函数。</p>

<p>正数的平方根有两个，只输出其中的正数平方根。</p>

<p>如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> x = 4
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> x = 8
<strong>输出:</strong> 2
<strong>解释:</strong> 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><meta charset="UTF-8" /><code>0 &lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 69&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/sqrtx/">https://leetcode-cn.com/problems/sqrtx/</a></p>
<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 1</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
