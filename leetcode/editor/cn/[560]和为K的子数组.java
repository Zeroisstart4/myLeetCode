//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 933 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

        // 用于统计和为K的子数组的个数
        int count = 0;
        // 用于记录前缀和
        int pre = 0;
        // 统计前缀和个数
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为 0 的子数组的个数
        map.put(0, 1);

        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 前缀和
            pre += nums[i];
            // 若前缀和 pre - k
            if(map.containsKey(pre - k)) {
                // 更新统计和
                count += map.get(pre - k);
            }
            // 更新前缀和个数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
