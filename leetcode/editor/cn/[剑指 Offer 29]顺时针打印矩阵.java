//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 240 👎 0

// 本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {

        // 若为空数组
        if (matrix.length == 0) {
            return new int[0];
        }

        // 左右边界(列)
        int left = 0;
        int right = matrix[0].length - 1;

        // 上下边界（行）
        int top = 0;
        int bottom = matrix.length - 1;

        // 新数组指针
        int index = 0;

        // 结果数组
        int[] res = new int[(right + 1)* (bottom + 1)];

        // 模拟过程
        while (true) {

            // 从左向右
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if(++top > bottom) {
                break;
            }

            // 从上向下
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if(--right < left) {
                break;
            }
            // 从右向左
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if(--bottom < top) {
                break;
            }
            // 从下向上
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if(++left > right) {
                break;
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
