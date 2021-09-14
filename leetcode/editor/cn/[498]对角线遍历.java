//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// Related Topics 数组 矩阵 模拟 👍 230 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {

        // 健壮性判断
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // 记录数组行列值
        int N = matrix.length;
        int M = matrix[0].length;

        // 初始化行列
        int row = 0, column = 0;

        // 跟踪我们正在处理当前对角线的方向的变量
        int direction = 1;

        // 结果数组
        int[] result = new int[N*M];
        // 结果数组索引
        int r = 0;

        // 遍历
        while (row < N && column < M) {

            // 结果值
            result[r++] = matrix[row][column];

            // 下一行 与 下一列
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // 检查对角线上的下一个元素是否在矩阵的边界内。如果它不在范围内，我们必须找到下一个头部。
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                if (direction == 1) {

                    // 对于以 [i, j] 作为尾部的向上对角线 如果 [i, j + 1] 在边界内，则它成为下一个头部。
                    // 否则，直接在下面的元素，即元素 [i + 1, j] 成为下一个头
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // 对于以 [i, j] 作为尾部的向下对角线，如果 [i + 1, j] 在边界内，则它成为下一个头部。
                    // 否则，直接在下面的元素，即元素 [i, j + 1] 成为下一个头
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // 翻转方向
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
