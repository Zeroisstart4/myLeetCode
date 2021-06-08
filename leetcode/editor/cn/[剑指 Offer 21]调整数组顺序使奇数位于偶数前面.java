//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 122 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针
    public int[] exchange(int[] nums) {
        // 左右指针
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 若左指针对应的元素值为奇数，左指针右移一位，并进行下一轮循环
            if((nums[left] & 1) != 0) {
                left++;
                continue;
            }

            // 若右指针对应的元素值为偶数，右指针左移一位，并进行下一轮循环
            if((nums[right] & 1) == 0) {
                right--;
                continue;
            }

            // 当左右指针指向的数分别为偶数与奇数时，偶数排在了奇数前，发生错位，需进行交换,
            // 同时，左指针右移一位，右指针左移一位
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
