//给定一个整数数组，找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 81 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {

        // 前 n 项和
        int pre = 0;
        // 结果
        int ans = nums[0];

        for (int num : nums) {

            // 若前 n 项和为负数，则进行舍弃，从第 n + 1 项开始累加
            pre = Math.max(pre + num, num);
            // 记录最大的多项和
            ans = Math.max(ans, pre);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
