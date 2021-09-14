/**
<p>给定一个字符串 <code>s</code> ，请计算这个字符串中有多少个回文子字符串。</p>

<p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abc"
<strong>输出：</strong>3
<strong>解释：</strong>三个回文子串: "a", "b", "c"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>"aaa"
<strong>输出：</strong>6
<strong>解释：</strong>6个回文子串: "a", "a", "a", "aa", "aa", "aaa"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 647 题相同：<a href="https://leetcode-cn.com/problems/palindromic-substrings/">https://leetcode-cn.com/problems/palindromic-substrings/</a>&nbsp;</p>
<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 5</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
