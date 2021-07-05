//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分法
    /*public int missingNumber(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if(nums[mid] == mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }*/

    // 异或法
    public int missingNumber(int[] nums) {
        // 缺失值
        int miss = 0;

        // 异或的特点：
        // 0 ^ x = x ^ 0 = x
        // x ^ x = 0; x ^ ~x = 1
        for (int i = 0; i < nums.length; i++) {
            miss ^= nums[i] ^ (i + 1);
        }

        return miss;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
