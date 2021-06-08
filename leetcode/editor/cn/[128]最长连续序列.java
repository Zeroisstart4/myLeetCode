//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 782 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {

        // 创建 set
        Set<Integer> set = new HashSet<>();

        // 将所有数组元素添加入 set
        for (int num : nums) {
            set.add(num);
        }

        // 结果值
        int res = 0;

        // 遍历 set
        for (Integer num : set) {
            // 若 set 不包含 num - 1， 则以 num 为起点
            if(!set.contains(num - 1)) {
                // 记录当前值与连续字串长度
                int curNum = num;
                int streak = 1;

                // 若 set 中包含 curNum + 1,则将当前值后移一位，连续字串长度 + 1
                while (set.contains(curNum + 1)) {
                    curNum++;
                    streak++;
                }

                res = Math.max(res, streak);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
