//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    public int nthUglyNumber(int n) {

        // 构建动态规划数组 dp
        int[] dp = new int[n + 1];

        // 初始化 dp[1] = 1, 表示第一位丑数为 1
        dp[1] = 1;

        // 用于构建丑数
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        // 构建丑数 1 - n 位丑数
        for (int i = 2; i <= n; i++) {

            // 构建丑数
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            dp[i] = Math.min(Math.min(num2, num3), num5);

            if(dp[i] == num2) {
                p2++;
            }
            if(dp[i] == num3) {
                p3++;
            }
            if(dp[i] == num5) {
                p5++;
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
