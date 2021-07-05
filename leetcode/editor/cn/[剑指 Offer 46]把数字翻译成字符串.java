//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 228 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滚动数组法
    /*public int translateNum(int num) {

        // 将数字转为字符串
        String s = String.valueOf(num);
        // 滚动数组第一位
        int a = 1;
        // 滚动数组第二位
        int b = 1;
        // 遍历
        for (int i = 2; i <= s.length(); i++) {
            // 截取两位连续字符串
            String temp = s.substring(i - 2, i);
            // 若其在 10 - 25，则可表示为 1 或 2 位字符，此时 c = a + b
            // 若其不在 10 - 25，则仅可表示 2 位字符，此时 c = a
            int c = (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) ? a + b : a;

            // 数字左移一位
            b = a;
            a = c;
        }

        return a;
    }*/

    // 动态规划
    public int translateNum(int num) {
        // 将数字转为字符串
        String s = String.valueOf(num);

        // 创建动态规划数组
        int[] dp = new int[s.length() + 1];
        // 若字符串长度为 0 ，则只有一种翻译方式
        dp[0] = 1;
        // 若字符串长度为 1 ，则只有一种翻译方式
        dp[1] = 1;
        // 遍历
        for (int i = 2; i <= s.length(); i++) {
            // 截取连续的两位字符
            String temp = s.substring(i - 2, i);
            // 若该字符串的字面量在 10 - 25 之间，则可以单独作为一位来翻译，也可以把这两位连起来翻译
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            // 若该字符串的字面量不在 10 - 25 之间，则仅可以单独作为一位来翻译
            else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
