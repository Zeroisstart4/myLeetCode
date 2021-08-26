//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 318 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        // 健壮性判断
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 记录数组行列长度
        int rows = matrix.length;
        int columns = matrix[0].length;

        // 遍历元素下标
        int row = 0;
        int column = columns - 1;

        // 遍历数组
        while (row < rows && column >= 0) {
            // 记录遍历元素值
            int num = matrix[row][column];
            // 若该元素恰好等于目标值，返回 true
            if(num == target) {
                return true;
            }
            // 若该元素小于目标值，下移一行
            else if(num < target) {
                row++;
            }
            // 若该元素大于目标值，左移一列
            else {
                column--;
            }
        }
        // 无匹配，返回 false
        return false;
    }


    /*public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }

        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
