//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1059 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 类冒泡排序思想
    /*public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] == 0) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }*/

    // 双指针优化
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int left = 0, right = 0;

        while (right < n) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

            right++;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
