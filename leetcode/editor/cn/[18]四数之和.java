//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 886 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 健壮性判断
        if (nums == null || nums.length < 4) {
            return res;
        }

        // 数组排序
        Arrays.sort(nums);
        // 记录数组长度
        int n = nums.length;

        // 第一个数
        for (int i = 0; i < n - 3; i++) {
            // 元素去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 若最小的四数之和仍大于目标值，则结束本轮循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 若当前数 + 最大的三个数仍小于目标值，剪枝
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }

            // 第二个数
            for (int j = i + 1; j < n - 2; j++) {
                // 元素去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 若最小的四数之和仍大于目标值，则结束本轮循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                // 若当前数 + 最大的三个数仍小于目标值，剪枝
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }

                // 第三个数
                int left = j + 1;
                // 第四个数
                int right = n - 1;
                // 遍历
                while (left < right) {
                    // 获取四数之和
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    // 若四数之和等于目标值
                    if (sum == target) {
                        // 加入结果数组
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 第三个数去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;

                        // 第四个数去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                    // 若四数之和小于目标值， 增大第三个数
                    else if (sum < target) {
                        left++;
                    }
                    // 若四数之和大于目标值，缩小第四个数
                    else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
