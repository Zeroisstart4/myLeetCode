//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 221 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 贪心算法
    /*
    public int cuttingRope(int n) {
        // 如果 n == 2，返回1，如果 n == 3，返回2
        if(n < 4) {
            return n - 1;
        }
        // 如果 n == 4，返回4

        // 如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
    */

    // 动态规划
    public int cuttingRope(int n) {
        // 表示长度为 i 的绳子剪成 m 段后的最大乘积
        int[] dp = new int[n + 1];
        // 长度为 2 的绳子剪成 2 段后的最大乘积
        dp[2] = 1;

        // i 表示绳子长度，绳子长度从 3 -> n
        for (int i = 3; i < n + 1; i++) {
            // 将绳子从长度为 2 开始剪，且保证剪下的绳子长度小于绳长
            for (int j = 2; j < i; j++) {

                // dp[i] 的转移方程
                // 在剪了第一段后，剩下绳子长度为 (i - j) ，可以继续剪也可以不剪。
                // 如果不剪的话长度乘积即为 j * (i - j)；    此次剪下的绳长 * 剩余绳长
                // 如果剪的话长度乘积即为 j * dp[i - j]；    此次剪下的绳长 * 绳长的长度积
                // 取两者最大值max(j * (i - j), j * dp[i - j])
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
