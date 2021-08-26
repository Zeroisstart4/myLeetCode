//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 485 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
       if(cur == nums.length) {
           ans.add(new ArrayList<Integer>(t));
           return;
       }
       dfs(false, cur + 1, nums);

       if(!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
           return;
       }
       t.add(nums[cur]);
       dfs(true, cur + 1, nums);
       t.remove(t.size() - 1);
    }*/


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
    }

    public void dfs(boolean choosePre, int[] nums, int index, List<Integer> list, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        }

        dfs(false, nums, index + 1, list, res);

        if (!choosePre && index > 0 && nums[index - 1] == nums[index]) {
            return;
        }

        list.add(nums[index]);
        dfs(true, nums, index, list, res);
        list.remove(list.size() - 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
