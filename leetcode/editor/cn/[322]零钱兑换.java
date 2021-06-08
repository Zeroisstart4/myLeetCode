//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1258 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 暴力查找
    /*public int coinChange(int[] coins, int amount) {
        // base case
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }

        // 迭代子问题
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subPro = coinChange(coins, amount - coin);
            if(subPro == -1) {
                continue;
            }

            res = Math.min(res, subPro + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }*/




/*    int[] memo;
    // 自顶向下动态规划
    public int coinChange(int[] coins, int amount) {
        // 设置备忘录数组
        memo = new int[amount + 1];
        // 设置初始值
        Arrays.fill(memo, -5);
        // 自顶向下动态规划
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }

        // 若 memo[amount] 发生过修改
        if(memo[amount] != -5) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 递归计算子问题结果
            int subPro = dp(coins, amount - coin);
            // 子问题无解，则跳过
            if(subPro == -1) {
                continue;
            }
            // 选择最优解
            res = Math.min(res, subPro + 1);
        }
        // 将结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);

        return memo[amount];
    }*/

    // 自底向上动态规划
    /*public int coinChange(int[] coins, int amount) {
        // 动态规划数组
        int[] dp = new int[amount + 1];
        // 初始化数组
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;

        // 最优子结构
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if(i - coin < 0) {
                    continue;
                }
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }*/


    public int coinChange(int[] coins, int amount) {

        // 定义动态规划数值，从 0 枚 --> amount 枚
        int[] dp = new int[amount + 1];

        // 填充所有元素为不可达数值，用与表示无穷大
        Arrays.fill(dp, amount + 1);

        // 表示 0 块钱需用 0 枚硬币进行拼成
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {

            for (int coin : coins) {

                // 若无法拼凑出正数硬币，或者说是当前硬币币额大于目标金额，无法拼凑，则进行下轮循环
                if(i - coin < 0) {
                    continue;
                }

                // 选择 dp[i - coin] + 1 与 dp[i] 间的最小值
                // 若存在分配方案，则为 dp[i - coin] + 1
                // 若不存在分配方案，则为 dp[i]
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        // 与 dp[i] = Math.min(dp[i - coin] + 1, dp[i]); 同理
        // dp[amount] == amount + 1 : 表示不存在分配方案
        // dp[amount] != amount + 1 : 表示存在分配方案
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
