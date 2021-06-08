//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {

        int votes = 0;
        int ans = 0;
        for (int num : nums) {
            if (votes == 0) {
                ans = num;
            }

            votes += num == ans ? 1 : -1;
        }

        if(votes > 0) {
            int count = 0;

            for (int num : nums) {
                if(num == ans) {
                    count++;
                }
            }

            if(count > nums.length / 2) {
                return ans;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
