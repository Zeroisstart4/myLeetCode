//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 542 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序
    /*public int findUnsortedSubarray(int[] nums) {

        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {

            if(newNums[i] != nums[i]) {

                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start > 0 ? end - start + 1 : 0;
    }*/

    // 两次遍历
    public int findUnsortedSubarray(int[] nums) {

        //找局部最大值，然后找到比局部最大值要小的值中最靠右的值的下标。
        int right = 0;
        int curMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if(curMax > nums[i]) {
                right = i;
            }
        }

        if(right == 0) {
            return 0;
        }

        //找局部最小值，然后找到比局部最小值要大的值中最靠左的值的下标。
        int left = 0;
        int curMin = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            curMin = Math.min(curMin, nums[i]);
            if(curMin < nums[i]) {
                left = i;
            }
        }

        return right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
