//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 
// 👍 333 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {

        // 健壮性判断
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 记录数组长度
        int n = nums.length;

        // dp[i] 表示以 i 索引为中止点的最长递增序列长度
        int[] dp = new int[n];
        // count[i] 表示以 i 索引为中止点的最长递增序列的个数
        int[] count = new int[n];

        // 初始化，最长递增序列长度为 1， 最长递增序列的个数为 1
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        // 结果值
        int res = 0;
        // 最长递增序列长度
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 若 i 索引前有数值小于 nums[i]
                if (nums[j] < nums[i]) {
                    // 则最长递增序列长度为 max(dp[j] + 1, dp[i])
                    // 当 dp[j] + 1 > dp[i] 时，以 i 索引为中止点的最长递增序列的个数更新
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    // 当 dp[j] + 1 == dp[i] 时， 以 i 索引为中止点的最长递增序列的个数类加
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            // 若最长递增序列长度大于 dp[i], 则更新 res
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = count[i];
            }
            // 若最长递增序列长度等于 dp[i], 则 res 累加 count[i]
            else if (dp[i] == maxLen) {
                res += count[i];
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
