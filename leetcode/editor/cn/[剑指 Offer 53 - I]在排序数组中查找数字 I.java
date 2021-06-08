//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 127 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    // 查找最右边的目标值对应的后一位索引
    public int binarySearch(int[] nums, int target) {

        // 左右边界
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // 计算中间索引
            int mid = (left + right) / 2;
            // 若中间值小于等于目标值，则将左边界重置为 mid + 1
            if(nums[mid] <= target) {
                left = mid + 1;
            }
            // 若中间值大于目标值，则将右边界重置为 mid - 1
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
