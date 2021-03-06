//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 98 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针法
    public int[] twoSum(int[] nums, int target) {

        // 左右指针
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 若两数之和小于目标值，则将左指针右移一位
            if (nums[left] + nums[right] < target) {
                left++;
            }
            // 若两数之和大于目标值，则将右指针左移一位
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            // 若两数之和等于目标值，返回这对数
            else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
