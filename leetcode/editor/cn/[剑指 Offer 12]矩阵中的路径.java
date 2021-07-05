//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 311 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        // 字符串转数组
        char[] words = word.toCharArray();
        // 遍历所有 board 数组的点，若存在一个匹配的字符序列，则返回 true
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
     *  DFS
     * @param board     给定的 m * n 二维字符网格
     * @param words     字符串单词数组
     * @param i         二维字符网格行下标
     * @param j         二维字符网格列下标
     * @param count     字符数组下标
     * @return
     */
    boolean dfs(char[][] board, char[] words, int i , int j, int count) {

        // 行或列索引越界，当前矩阵元素与目标字符不同或当前矩阵元素已访问过时，返回 false
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[count]) {
            return false;
        }

        // 若完成字符匹配，则返回 true
        if(count == words.length - 1) {
            return true;
        }

        // 标记当前位置已被访问，为防止之后搜索时重复访问，board[i][j] 修改为 空字符 '\0'
        board[i][j] = '\0';

        // 对当前点的上下左右进行递归
        boolean res =
                   dfs(board, words, i + 1, j ,count + 1)
                || dfs(board, words, i - 1, j, count + 1)
                || dfs(board, words, i, j + 1, count + 1)
                || dfs(board, words, i, j - 1, count + 1);

        // 恢复当前点的原值
        board[i][j] = words[count];

        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
