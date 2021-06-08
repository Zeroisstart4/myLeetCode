//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。 
//
// 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。 
//
// 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。 
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [0,1,3,5,6,8,12,17]
//输出：true
//解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然
//后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。 
//
// 示例 2： 
//
// 
//输入：stones = [0,1,2,3,4,8,9,11]
//输出：false
//解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。 
//
// 
//
// 提示： 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 231 - 1 
// stones[0] == 0 
// 
// Related Topics 动态规划 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*private Boolean[][] rec;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (rec[i][lastDis] != null) {
            return rec[i][lastDis];
        }

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return rec[i][lastDis] = true;
                }
            }
        }
        return rec[i][lastDis] = false;
    }*/


    // 动态规划
    public boolean canCross(int[] stones) {

        // 记录数组长度
        int n = stones.length;

        // 定义动态规划数组，例如 dp[m][n] 表示跳跃长度为 n 时，能否跳到从第 m 块石头
        boolean[][] dp = new boolean[n][n];

        dp[0][0] = true;

        for (int i = 1; i < n; i++) {

            // 当第 i - 1 块石头到第 i 块石头的距离大于 (i - 1) + 1 时，无法跳达，返回 false
            if(stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            for (int j = i - 1; j >= 0; j--) {

                // 记录第 j 块石头到达第 i 块石头的距离
                int k = stones[i] - stones[j];

                // 若距离大于所能跳的距离上限，则中止循环
                if (k > j + 1) {
                    break;
                }

                // 状态转移方程
                // 能否跳到第 i 块石头取决于第 j 块石头能否跳达
                // 跳转到第 j 块石头的方法有三种，
                // 1. 跳 k - 1 步
                // 2. 跳 k 步
                // 3. 跳 k + 1 步
                // 进行或操作，只需要有一种方式能够跳达即可
                // dp[j][k - 1]表示跳跃长度为 k - 1 时，能否跳到从第 j 块石头
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];


                // 当青蛙可跳至最后一块石头时
                if(i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
