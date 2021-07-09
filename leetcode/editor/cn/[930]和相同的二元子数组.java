//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 150 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // 求和
        int sum = 0;
        // 计数 hash 表
        Map<Integer, Integer> count = new HashMap<>();
        // 结果值
        int res = 0;
        // 遍历
        for (int num : nums) {
            count.put(sum, count.getOrDefault(sum, 0) + 1);
            sum += num;
            res += count.getOrDefault(sum - goal, 0);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
