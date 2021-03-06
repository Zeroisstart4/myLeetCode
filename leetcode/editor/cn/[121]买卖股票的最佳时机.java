//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 贪心算法
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            // 尽量选择在价格最低处买入（位于当前遍历索引及其左侧）
            low = Math.min(low, prices[i]);
            // 在价格最大处抛出，若 prices[i] - low 始终小于等于 0 ，则不买入
            res = Math.max(res, prices[i] - low);
        }

        return res;
    }

    //动态规划
    /*
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][2];
        // 若你第 0 天买入股票，则你当前持有的现金为 ？
        dp[0][0] = -prices[0];
        // 假设你的启动资金为 0 ，空手套白狼
        dp[0][1] = 0;

        for (int i = 0; i < len; i++) {
            // 若你在第 i 天买入股票，你需要尽可能的减少支出
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            // 若你在第 i 天抛出股票，你需要尽可能的增加收入
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
        }
        return dp[len-1][1];
    }
    */

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        // 未持有股票时的最大利润
        dp[0][0] = 0;
        // 持有股票时的最大利润
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
