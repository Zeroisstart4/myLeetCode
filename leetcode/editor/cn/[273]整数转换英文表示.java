/**
<p>将非负整数 <code>num</code> 转换为其对应的英文表示。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num = 123
<strong>输出：</strong>"One Hundred Twenty Three"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num = 12345
<strong>输出：</strong>"Twelve Thousand Three Hundred Forty Five"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>num = 1234567
<strong>输出：</strong>"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>num = 1234567891
<strong>输出：</strong>"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= num <= 2<sup>31</sup> - 1</code></li>
</ul>
<div><li>👍 204</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000)
        {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" "); sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    public void recursion(StringBuffer curr, int num) {
        if (num == 0) {
            return;
        }
        else if (num < 10) {
            curr.append(singles[num]).append(" ");
        }
        else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        }
        else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        }
        else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
