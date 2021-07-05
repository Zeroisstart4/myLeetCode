//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 140 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 集合 Set + 遍历
    /*public boolean isStraight(int[] nums) {
        // set 查重
        Set<Integer> repeat = new HashSet<>();
        // 记录最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 遍历
        for (int num : nums) {
            // 若为大小王，跳过
            if(num == 0) {
                continue;
            }
            // 更新最大最小值
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 查重
            if(!repeat.add(num)) {
                return false;
            }
        }

        return max - min < 5;
    }*/

    // 排序遍历
    public boolean isStraight(int[] nums) {
        // 大小王个数
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        // 遍历
        for (int i = 0; i < nums.length - 1; i++) {
            // 统计大小王的个数
            if(nums[i] == 0) {
                joker++;
            }
            // 若发生重复，直接返回 false
            else if(nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
