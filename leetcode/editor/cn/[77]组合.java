//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 677 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (n < 1 || k < 0) {
            return res;
        }
        dfs(res, list, 1, n, k);

        return res;
    }

    /**
     *      DFS
     * @param res       结果集数组
     * @param list      一个结果集
     * @param cur       当前值 （1 - n）
     * @param n         最大值
     * @param k         个数
     */
    public void dfs(List<List<Integer>> res, List<Integer> list, int cur, int n, int k) {

        // 减枝， 若结果集中元素个数 + 待添加元素个数仍小于 k, 则无法拼接出结果，裁去
        if (list.size() + (n - cur + 1) < k) {
            return;
        }

        // 满足条件结果
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 不添加 cur, 进入下一层
        dfs(res, list, cur + 1, n, k);

        // 添加 cur, 进入下一层
        list.add(cur);
        dfs(res, list, cur + 1, n, k);
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
