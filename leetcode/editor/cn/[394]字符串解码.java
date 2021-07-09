//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 794 👎 0


import org.apache.lucene.util.automaton.CharacterRunAutomaton;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 字符串共享
    String src;
    // 字符串索引
    int ptr;

    public String decodeString(String s) {

        src = s;
        ptr = 0;

        return getString();
    }

    public String getString() {

        // 递归中止条件
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }

        // 获取当前元素
        char cur = src.charAt(ptr);
        // 重复次数
        int repTime = 1;
        // 结果字符串
        String res = "";

        if (Character.isDigit(cur)) {

            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ptr++;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ptr++;
            // 构造字符串
            while (repTime-- > 0) {
                res += str;
            }
        }
        else if (Character.isLetter(cur)) {
            res += String.valueOf(src.charAt(ptr++));
        }

        return res + getString();
    }

    /**
     * 字符串转数字
     * @return
     */
    public int getDigits() {
        // 结果值
        int res = 0;
        // 若索引小于字符串长度且索引对应的元素为 0 - 9 的字符时
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            res = res * 10 + (src.charAt(ptr++) - '0');
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
