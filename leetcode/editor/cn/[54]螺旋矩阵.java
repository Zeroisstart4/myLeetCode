//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 772 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> arr = new ArrayList<>();
        // 健壮性判断
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return arr;
        }

        // 上下边界
        int left = 0;
        int right = matrix[0].length - 1;

        // 左右边界
        int top = 0;
        int bottom = matrix.length - 1;

        while (true) {

            // 顶部： 从左向右
            for (int i = left; i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            // 每从左向右一次，上边界下移一位
            if(++top > bottom) {
                break;
            }

            // 右部： 从上向下
            for (int i = top; i <= bottom; i++) {
                arr.add(matrix[i][right]);
            }
            // 每从上向下一次，右边界左移一位
            if(--right < left) {
                break;
            }

            // 从右向左
            for (int i = right; i >= left; i--) {
                arr.add(matrix[bottom][i]);
            }
            // 每从右向左一次，下边界上移一位
            if(--bottom < top) {
                break;
            }

            // 从下向上
            for (int i = bottom; i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            // 每从下向上一次，左边界右移一位
            if(++left > right) {
                break;
            }

        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
