//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 85 👎 0


import com.sun.org.apache.xml.internal.utils.res.XResourceBundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.fill(board, '.');
        baxkTrack(board, 0);

        return res;
    }


    void baxkTrack(char[][] board, int row) {

        if(row == board.length - 1) {
            res.add(generate(board));
            return;
        }

        int n = board[0].length;

        for (int j = 0; j < n; j++) {

            if(!isValid(board, row, j)) {
                continue;
            }

            board[row][j] = 'Q';

            baxkTrack(board, row + 1);

            board[row][j] = '.';
        }
    }


    boolean isValid(char[][] board, int row, int column) {

        int n = board.length;

        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if(board[i][column] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = column - 1; i >= 0 && j < n; i--, j++) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<String> generate(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            res.add(row.toString());
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
