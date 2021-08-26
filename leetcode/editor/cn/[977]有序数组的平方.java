//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 252 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分排序
    public int[] sortedSquares(int[] nums) {

        // 记录数组长度
        int len = nums.length;
        // 负数指针，用于获取最后一位负数对应的索引
        int negative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative = i;
            }
            else {
                break;
            }
        }

        // 结果数组
        int[] ans = new int[len];

        int i = negative;
        int j = negative + 1;
        int index = 0;
        while (i >= 0 || j < len) {
            
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            else if (j == len) {
                ans[index] = nums[i] * nums[i];
                i--;
            }
            else if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                i--;
            }
            else {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            
            index++;
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
