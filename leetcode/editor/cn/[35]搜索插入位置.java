//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 964 👎 0


class Solution {
    /*public int searchInsert(int[] nums, int target) {

        // 左右指针
        int left = 0;
        int right = nums.length - 1;
        // 插入索引
        int index = nums.length;

        // 遍历
        while (left <= right) {
            // 计算中间索引
            int mid = left + (right - left) / 2;
            // 若中间值大于等于目标值
            if (nums[mid] >= target) {
                // 修改索引与右边界
                index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return index;
    }*/

    public int searchInsert(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        int insert = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                insert = mid;
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return insert;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
