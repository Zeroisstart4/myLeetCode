/**
<p>给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含&nbsp;<strong>连续的1&nbsp;</strong>的个数。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 5
<strong>输出:</strong> 5
<strong>解释:</strong> 
下面是带有相应二进制表示的非负整数&lt;= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。</pre>

<p><strong>说明:</strong> 1 &lt;= n &lt;= 10<sup>9</sup></p>
<div><div>Related Topics</div><div><li>动态规划</li></div></div><br><div><li>👍 181</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findIntegers(int n) {

        int[] dp = new int[31];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i  - 1] + dp[i - 2];
        }

        int pre = 0;
        int res = 0;

        for (int i = 29; i >= 0; i--) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            }
            else {
                pre = 0;
            }

            if (i == 0) {
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
