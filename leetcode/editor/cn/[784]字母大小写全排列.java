//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 290 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public List<String> letterCasePermutation(String s) {

        // 结果集
        List<String> res = new ArrayList<>();
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // 健壮性判断
        if (s == null) {
            return res;
        }
        // 回溯
        backtrack(s, 0, sb, res);

        return res;
    }

    /**
     *      回溯
     * @param s         源字符串
     * @param index     当前字符索引
     * @param sb        一个结果
     * @param res       结果集合
     */
    private void backtrack(String s, int index, StringBuilder sb, List<String> res) {

        // 完成搜索
        if (s.length() == index) {
            res.add(sb.toString());
            return;
        }

        // 获取当前字符
        char ch = s.charAt(index);

        // 若为数字，回溯
        if (Character.isDigit(ch)) {
            sb.append(ch);
            backtrack(s, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 若为字母，转为大小写回溯
        else {

            char lower = Character.toLowerCase(ch);
            sb.append(lower);
            backtrack(s, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);

            char upper = Character.toUpperCase(ch);
            sb.append(upper);
            backtrack(s, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
