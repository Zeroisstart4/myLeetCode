//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 
// 👍 1 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // 结果集合
        List<List<Integer>> res = new ArrayList<>();
        // 一个结果
        List<Integer> subList = new ArrayList<>();
        // 健壮性判断
        if (nums == null) {
            return res;
        }

        backtarck(nums, 0, subList, res);

        return res;
    }

    private void backtarck(int[] nums, int index, List<Integer> subList, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subList.contains(nums[i])) {
                continue;
            }

            subList.add(nums[i]);
            backtarck(nums, index + 1, subList, res);
            subList.remove(subList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
