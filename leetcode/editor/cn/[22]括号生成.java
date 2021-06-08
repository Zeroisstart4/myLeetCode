//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1805 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), 0, 0, n);

        return res;
    }


    /**
     * 回溯
     * @param res       结果集
     * @param str       拼接字符
     * @param open      左括号
     * @param close     右括号
     * @param max       最大括号对数
     */
    public void backTrack(List<String> res, StringBuilder str, int open, int close, int max) {

        // 若匹配成功，则添加入结果集
        if(str.length() == max * 2) {
            res.add(str.toString());
            return;
        }

        // 进行左括号匹配
        if(open < max) {
            // 做出选择
            str.append('(');
            // 进入下一层
            backTrack(res, str, open + 1, close, max);
            // 撤销选择
            str.deleteCharAt(str.length() - 1);
        }

        // 进行右括号匹配
        if(close < open) {
            // 做出选择
            str.append(')');
            // 进入下一层
            backTrack(res, str, open, close + 1, max);
            // 撤销选择
            str.deleteCharAt(str.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
