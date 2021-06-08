//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 787 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        // 设定最佳值为最大值
        int best = 10000;

        // 枚举
        for (int i = 0; i < len; i++) {
            // 去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左右指针
            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                // 三数求和
                int sum = nums[i] + nums[L] + nums[R];
                // 若恰好匹配
                if(sum == target) {
                    return target;
                }
                // 更新 best
                if(Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                // 若三数之和比目标值大，移动右指针
                if(sum > target) {
                    R--;
                }
                // 若三数之和比目标值小，移动左指针
                else {
                    L++;
                }
            }
        }

        return best;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
