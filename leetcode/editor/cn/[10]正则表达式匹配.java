//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 2147 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {

        // 记录字符串长度
        int m = s.length();
        int n = p.length();

        // 创建动态规划数组
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 皆为空字符可发生匹配
        dp[0][0] = true;

        // 遍历字符
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 若字符为 *
                if (p.charAt(j - 1) == '*') {
                    // x* 不匹配任意字符
                    dp[i][j] = dp[i][j - 2];
                    // x* 匹配任意字符
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                // 若字符不为 *
                else {
                    // 若满足匹配规则，则 dp[i][j] 的匹配情况与 dp[i - 1][j - 1] 相同
                    if(matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    /**
     *  在没有 * 情况下的字符匹配
     * @param s     代匹配字符串
     * @param p     匹配规则字符串
     * @param i     代匹配字符索引
     * @param j     匹配规则字符索引
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {

        // 若皆为空字符，可发生匹配
        if (i == 0 && j == 0) {
            return true;
        }

        // 若仅有一个为空字符，不可匹配
        if (i == 0 || j == 0) {
            return false;
        }
        // 若匹配规则字符为 . 可匹配任意一位字符
        if(p.charAt(j - 1) == '.') {
            return true;
        }

        // 检查字符是否相同
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
