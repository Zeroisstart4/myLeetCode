//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 371 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分查找法
    public boolean searchMatrix(int[][] matrix, int target) {
        // 养成好习惯，健壮性判断
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        // 记录 matrix 数组的行数与列数
        int row = matrix.length, col = matrix[0].length;
        // 记录二分查找上下限
        int left = 0, right = row * col - 1;

        // 别忘了 = 的情况
        while (left <= right) {
            // 记录中位对应的索引
            // 之所以使用 (right - left) / 2 + left 而不是使用 (left + right) / 2,
            // 是因为 left + right 可能会发生溢出
            int mid = (right - left) / 2 + left;
            // 获取中位索引对应的数组元素
            // 该元素的所在行为 mid / col, 所在列为 mid % col
            int element = matrix[mid/col][mid%col];
            // 二分查找核心
            // 若中位元素小于目标元素，表明目标元素（若存在）位于中位元素右侧，提高下限
            if(element < target) {
                left = mid + 1;
            }
            else if(element > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
