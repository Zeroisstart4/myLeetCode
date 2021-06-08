//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1216 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 贪心算法
    /*public boolean canJump(int[] nums) {
        // 记录数组长度
        int n = nums.length;
        // 表示能到达的最远值
        int right = 0;

        for (int i = 0; i < n; i++) {

            if(i <= right) {
                right = Math.max(right, i + nums[i]);
                if(right >= n - 1) {
                    return true;
                }
            }
        }

        return false;
    }*/

    // 动态规划
    public boolean canJump(int[] nums) {

        int len = nums.length;

        if(len <= 1) {
            return true;
        }

        boolean[] dp = new boolean[len];

        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {

                if(dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
