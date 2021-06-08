//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 906 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *      回溯
     * @param board         二维字符网格
     * @param words         字符串单词数组
     * @param i             横坐标
     * @param j             纵坐标
     * @param index         字符串单词数组索引
     * @return
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {

        //边界的判断
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]) {
            return false;
        }

        //如果word的每个字符都查找完了，直接返回true
        if(index == words.length - 1) {
            return true;
        }

        //把当前坐标的值保存下来，为了在最后复原
        char temp = board[i][j];

        //然后修改当前坐标的值, 表示已访问
        board[i][j] = '.';

        //递归
        boolean res = dfs(board, words, i + 1, j, index + 1) ||
                dfs(board, words, i - 1, j, index + 1) ||
                dfs(board, words, i, j + 1, index + 1) ||
                dfs(board, words, i, j - 1, index + 1);

        //递归之后再把当前的坐标复原
        board[i][j] = temp;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
