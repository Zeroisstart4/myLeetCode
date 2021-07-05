//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1355 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }


    /**
     *      回溯查找组合
     * @param res           结果集
     * @param candidates    无重复元素的数组
     * @param list          一个组合
     * @param target        组合的目标值
     * @param index         无重复元素的数组索引
     */
    private void dfs(List<List<Integer>> res, int[] candidates, List<Integer> list, int target, int index) {

        //终止条件判断，防止数组越界异常
        if(index == candidates.length) {
            return;
        }
        // 若存在组合，使得组合值为 target，则添加入结果集
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        //每一个节点都有两个分支，选 / 不选
        // 不选，接跳过，索引 + 1
        dfs(res, candidates, list, target, index + 1);

        // 选，选择当前数，判断当前选择值是否小于等于目标值
        if(target - candidates[index] >= 0) {
            // 做出选择
            list.add(candidates[index]);
            // 进入下一层
            dfs(res, candidates, list, target - candidates[index], index);
            //撤销选择
            list.remove(list.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
