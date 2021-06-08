//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        // 用于拼接字符串
        StringBuffer sb = new StringBuffer();
        // 记录字符长度
        int n = s.length();
        // 用于记录单个单词长度
        int index = 0;

        while (index < n) {

            int start = index;
            while (index < n && s.charAt(index) != ' ') {
                index++;
            }

            for (int i = start; i < index; i++) {
                sb.append(s.charAt(start + index - 1 - i));
            }

            while (index < n && s.charAt(index) == ' ') {
                index++;
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
