//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 956 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {

        // 健壮性判断
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // 记录数组长度
        int row = matrix.length;
        int col = matrix[0].length;

        // 每行连续一的个数
        int[][] left = new int[row][col];

        // 遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 若 matrix[i][j] 为字符 ‘1’
                if (matrix[i][j] == '1') {
                    // 则统计连续的一的个数
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        // 结果值
        int res = 0;
        // 逐列遍历
        for (int j = 0; j < col; j++) {
            // 上下界数组
            int[] up = new int[row];
            int[] down = new int[row];
            // 单调栈
            Deque<Integer> stack = new LinkedList<>();
            // 从上到下
            for (int i = 0; i < row; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            // 清空栈
            stack.clear();
            // 从下到上
            for (int i = row - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? row : stack.peek();
                stack.push(i);
            }

            // 求取最大面积
            for (int i = 0; i < row; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                res = Math.max(res, area);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
