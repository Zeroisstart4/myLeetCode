//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 308 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    /**
     * 深度优先
     * @param res       结果数组
     * @param list      每一子集
     * @param begin     起始数值
     * @param k         数字个数
     * @param n         目标值
     */
    private void dfs(List<List<Integer>> res, List<Integer> list, int begin, int k, int n) {

        // 当残余的数字个数与目标值皆为零时
        if(k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = begin; i <= 9; i++) {

            // 若目标值小于 i ，进行下轮循环
            if(n < i) {
                continue;
            }
            // 若目标值大于等于 i ，则将 i 加入列表
            list.add(i);
            // 递归，起始数值为 i+ 1， 余下数字个数为 k - 1，目标值减小为 n - i
            dfs(res, list, i + 1, k - 1, n - i);
            // 回溯
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
