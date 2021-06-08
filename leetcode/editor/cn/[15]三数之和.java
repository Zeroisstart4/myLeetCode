//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3379 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 若数组为空或者数组长度小于 3，则无法完成三数之和
        if(nums == null || nums.length < 3) {
            return res;
        }
        // 记录数组长度
        int len = nums.length;
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 若 nums[i] > 0，由于数组有序，后续的另外两个数也将大于 0,无法满足三数之和为 0
            if(nums[i] > 0) {
                break;
            }
            // 去重，避免出现重复结果
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左右指针
            int L = i + 1;
            int R = len - 1;

            // 遍历
            while (L < R) {
                // 求和
                int sum = nums[i] + nums[L] + nums[R];
                // 若三数之和为 0
                if(sum == 0) {
                    // 加入结果集
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    // 移动指针
                    L++;
                    R--;
                }
                // 若三数之和小于 0，缓慢增大
                else if(sum < 0) {
                    L++;
                }
                // 若三数之和小于 0，快速缩小
                else if(sum > 0) {
                    R--;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
