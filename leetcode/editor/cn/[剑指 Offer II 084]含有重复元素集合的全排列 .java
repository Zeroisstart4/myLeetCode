//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 
// 👍 1 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int len = nums.length;
        boolean[] isVist = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, 0, isVist, subList, res);

        return res;
    }

    private void backtrack(int[] nums, int index, boolean[] isVist, List<Integer> subList, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVist[i] || i > 0 && (nums[i] == nums[i - 1] && !isVist[i - 1])) {
                continue;
            }

            subList.add(nums[i]);
            isVist[i] = true;
            backtrack(nums, index + 1, isVist, subList, res);
            isVist[i] = false;
            subList.remove(subList.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
