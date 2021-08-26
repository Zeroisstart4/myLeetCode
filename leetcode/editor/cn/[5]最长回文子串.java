//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3434 👎 0


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    /*public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }*/

    public String longestPalindrome(String s) {
        // 记录数组长度
        int n = s.length();
        // 创建 dp 数组
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        //  i -> j 的间隔
        for (int len = 0; len < n; len++) {
            // 下标索引 i, j
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                // 字符长度为 1 时，一定是回文串
                if(len == 0) {
                    dp[i][j] = true;
                }
                // 字符长度为 2 时，字符相同即为回文串
                else if(len == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                // 字符长度大于 2 时，比较首位字符后，比较首字符后移一位，尾字符前移一位的结果
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                // 若 i -> j 为回文字串，且长度比结果串长，更新结果
                if(dp[i][j] && len + 1 > ans.length()) {
                    ans = s.substring(i, i + len + 1);
                }
            }
        }

        return ans;
    }


    /*public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        String res = "";
        for (int len = 0; len < n; len++) {

            for (int i = 0; i + len < n; i++) {

                int j = i + len;

                if (len == 0) {
                    dp[i][j] = true;
                }
                else if (len == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && res.length() < len) {
                    res = s.substring(i, i + len + 1);
                }
            }
        }

        return res;
    }*/

    /*public String longestPalindrome(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        String res = "";

        for (int len = 0; len < n; len++) {

            for (int i = 0; i + len < n; i++) {

                int j = i + len;

                if (len == 0) {
                    dp[i][j] = true;
                }
                else if (len == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && res.length() < len + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
