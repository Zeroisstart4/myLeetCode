//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 677 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    /*int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        caculate(nums, 0, 0, target);
        return count;
    }

    */

    /**
     * 计算
     * @param nums          整数数组
     * @param index         索引值
     * @param sum           所有数的和
     * @param target        目标和
     */
    /*
    public void caculate(int[] nums, int index, int sum, int target) {

        // 递归中止条件
        if(index == nums.length) {
            // 若和为目标值，计数 + 1
            if(sum == target) {
                count++;
            }
        }
        else {
            caculate(nums, index + 1, sum - nums[index], target);
            caculate(nums, index + 1, sum + nums[index], target);
        }
    }*/


    public int findTargetSumWays(int[] nums, int target) {

        int[][] dp = new int[nums.length][2001];

        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if(dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }

        return target > 1000 ? 0 : dp[nums.length - 1][target + 1000];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
