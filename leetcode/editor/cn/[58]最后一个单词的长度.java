//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 323 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针
    public int lengthOfLastWord(String s) {

        // 健壮性判断
        if(s == null || s.length() == 0) {
            return 0;
        }

        // 记录字符串末尾索引
        int end = s.length() - 1;

        // 去除末尾空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // 若去除空格后索引小于 0， 表示原字符串中皆为空格
        if(end < 0) {
            return 0;
        }

        // 记录起始位置
        int start  = end;
        // 若起始索引处的字符不为空格，前移一位
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
