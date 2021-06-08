//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        // 第一位不重复数
        int x = 0;
        int y = 0;
        int n = 0;
        int m = 1;

        // 1. 遍历异或
        for (int num : nums) {
            n ^= num;
        }

        // 2. 循环左移，计算 m
        while ((n & m) == 0) {
            m <<= 1;
        }

        // 3. 遍历 nums 分组
        for (int num : nums) {
            // 4. 当 num & m != 0
            if((num & m) != 0) {
                x ^= num;
            }
            // 4. 当 num & m == 0
            else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
