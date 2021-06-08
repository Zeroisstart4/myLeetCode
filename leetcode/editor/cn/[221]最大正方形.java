//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 771 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {

        //二维矩阵的宽和高
        int hight = matrix.length;
        int width = matrix[0].length;

        int[][] dp = new int[hight + 1][width + 1];
        //最大正方形的宽
        int maxsize = 0;

        for (int i = 1; i <= hight; i++) {
            for (int j = 1; j <= width; j++) {

                if(matrix[i - 1][j - 1] == '1') {
                    //递推公式
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

                maxsize = Math.max(maxsize, dp[i][j]);
            }
        }

        return maxsize * maxsize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
