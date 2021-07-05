//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1117 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0);

        return res;
    }

    /**
     * 深度优先
     * @param res       结果集
     * @param nums      原始数组
     * @param list      一个子集
     * @param index     对应的数组索引
     */
    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
        //终止条件判断
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        //每一个节点都有两个分支，一个选一个不选
        //走不选这个分支
        dfs(res, nums, list, index + 1);

        //走选择这个分支
        list.add(nums[index]);
        dfs(res, nums, list, index + 1);
        //撤销选择
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
