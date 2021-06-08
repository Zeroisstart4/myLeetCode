//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 记忆化
    int[][] memo;
    public int numTrees(int n) {
        // 初始化数组
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**
     * 统计 low - high 的排列数
     * @param low       低位索引
     * @param high      高位索引
     * @return
     */
    public int count(int low, int high) {

        // 递归中止条件
        if(low > high) {
            return 1;
        }

        int res = 0;
        // 检查记忆化数组是否已记录，避免重复子问题
        if(memo[low][high] != 0) {
            return memo[low][high];
        }
        for (int i = low; i <= high; i++) {

            int left = count(low, i - 1);
            int right = count(i + 1, high);

            res += left * right;
        }

        memo[low][high] = res;

        return res;
    }

    /*public int count(int low, int high) {

        if(low > high) {
            return 1;
        }

        int res = 0;

        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);

            res += left * right;
        }

        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
