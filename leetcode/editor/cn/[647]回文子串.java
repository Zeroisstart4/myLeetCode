//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 582 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {

        // 记录数组长度
        int len = s.length();
        // 创建动态规划数组，dp[i][j] 表示从 i -> j 是否为回文串
        boolean[][] dp = new boolean[len][len];
        // 统计回文串总数
        int count = 0;
        // 遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 若 i 索引处的字符与 j 索引处的字符不同，则不是回文字符，跳过
                if(s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                // 状态转移方程
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];

                // 若是回文串，则计数 + 1
                if(dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
