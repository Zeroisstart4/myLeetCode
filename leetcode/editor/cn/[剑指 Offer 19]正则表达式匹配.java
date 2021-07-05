//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划 
// 👍 223 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {

        // 记录数组长度
        int m = s.length();
        int n = p.length();

        // 创建动态规划数组, dp[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化条件，两个空字符串是可以匹配的
        dp[0][0] = true;

        // 遍历
        for (int i = 0; i <= m; i++) {
            // 从 dp[0][1] 开始
            for (int j = 1; j <= n; j++) {
                // 若模式字符串的第 j 位为 *，则首先查看 dp[i][j - 2] 能否发生匹配( x* 匹配 0 位的情况)
                if (p.charAt(j - 1) == '*') {
                    // x* 匹配零位
                    dp[i][j] = dp[i][j - 2];
                    // 同时，查询 s 的前 i 个字符与 p 中的前 j - 1 个字符是否能够匹配( x* 匹配多位的情况)
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                // 若模式字符串的第 j 位不为 *
                else {
                    // 查询 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }
        }

        return dp[m][n];

    }

    /**
     *  判断在没有 “*” 的条件下，s 的第 i 个字符与p 的第 j 个字符可否匹配
     * @param s     输入字符串
     * @param p     匹配模式
     * @param i     s 的第 i 个字符
     * @param j     p 的第 j 个字符
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {
        // 若都为空串
        if (i == 0 && j == 0) {
            return true;
        }
        // 若仅有一个为空串
        if (i == 0 || j == 0) {
            return false;
        }
        // 若索引 j - 1 处的字符为 ‘.’， 则可以与任意一个字符匹配
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        // 字符串 s 的第 i 个字符与 p 的第 j 个字符是否相等
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
