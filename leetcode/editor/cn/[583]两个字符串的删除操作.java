/**
<p>给定两个单词&nbsp;<em>word1&nbsp;</em>和&nbsp;<em>word2</em>，找到使得&nbsp;<em>word1&nbsp;</em>和&nbsp;<em>word2&nbsp;</em>相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> &quot;sea&quot;, &quot;eat&quot;
<strong>输出:</strong> 2
<strong>解释:</strong> 第一步将&quot;sea&quot;变为&quot;ea&quot;，第二步将&quot;eat&quot;变为&quot;ea&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>给定单词的长度不超过500。</li>
	<li>给定单词中的字符只含有小写字母。</li>
</ol>
<div><li>👍 273</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {

        // 记录字符串长度
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示 word1 从 0 -> i - 1, word2 从 0 -> j - 1 的最长公共子串
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];

        return (m - lcs) + (n - lcs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
