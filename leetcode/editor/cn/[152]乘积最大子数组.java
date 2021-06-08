//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {

        // 记录数组长度
        int len = nums.length;

        // 最大最小乘积数组
        int[] maxM = new int[len];
        int[] minM = new int[len];

        // 数组初始化
        System.arraycopy(nums, 0, maxM, 0, len);
        System.arraycopy(nums, 0, minM, 0, len);

        for (int i = 1; i < len; i++) {
            // 最大最小乘积数组
            maxM[i] = Math.max(maxM[i - 1] * nums[i], Math.max(nums[i], minM[i - 1] * nums[i]));
            minM[i] = Math.min(minM[i - 1] * nums[i], Math.min(nums[i], maxM[i - 1] * nums[i]));
        }

        int ans = maxM[0];
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, maxM[i]);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
