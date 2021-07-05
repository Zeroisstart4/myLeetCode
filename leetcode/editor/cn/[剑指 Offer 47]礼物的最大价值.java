//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 141 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int maxValue(int[][] grid) {

        //边界条件判断
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        //初始化dp的最左边一列，从上到下累加
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //初始化dp的最上面一行，从左到右累加
        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }*/



    // 动态规划优化
    public int maxValue(int[][] grid) {

        //边界条件判断
        if(grid == null || grid.length == 0) {
            return 0;
        }

        // 记录数组行列
        int rows = grid.length;
        int comlumns = grid[0].length;

        // 创建动态规划数组
        int[][] dp = new int[rows + 1][comlumns + 1];

        // 从左上角开始，获取最大礼物价值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < comlumns; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }

        return dp[rows][comlumns];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
