//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 30 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {

        // 记录数组行列长度
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录数组出现 0 的行与列
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];

        // 遍历数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 若数组的 （i，j） 位置为 0， 则将该行该列置为 true
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        // 将出现 0 的行与列元素设置为 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
