//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 347 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {

        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 1) {
                count++;
            }
            else {
                count--;
            }

            if(map.containsKey(count)) {
                int preIndex = map.get(count);
                maxLen = Math.max(maxLen, i - preIndex);
            }
            else {
                map.put(count, i);
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
