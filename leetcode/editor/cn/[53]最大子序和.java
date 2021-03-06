//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int res = nums[0];

        for (int num : nums) {

            // 判断当前数值是否为负数，若是，则舍弃之前所有元素
            sum = Math.max(sum + num, num);
            // 记录最大值
            res = Math.max(res, sum);
        }

        return res;
    }

    /*public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];

        for (int num : nums) {

            sum = Math.max(sum + num, num);

            res = Math.max(res, sum);
        }

        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
