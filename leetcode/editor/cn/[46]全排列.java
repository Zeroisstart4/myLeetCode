//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
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
// Related Topics 回溯算法 
// 👍 1379 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        backTrack(nums, new ArrayList<>());

        return res;
    }

    /**
     *
     * @param nums
     * @param list
     */
    public void backTrack(int[] nums, List<Integer> list) {

        // 递归中止条件
        if(nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 遍历 N 叉树
        for (int i = 0; i < nums.length; i++) {

            // 跳过已添加的节点，用于剪枝
            if(list.contains(nums[i])) {
                continue;
            }

            // 做出决策
            list.add(nums[i]);
            // 进入下一层决策
            backTrack(nums, list);
            // 撤销决策
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
