//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // stringBuilder 字符拼接
    /*public String reverseLeftWords(String s, int n) {

        // 字符串长度
        int len = s.length();
        // 取余简化操作次数
        int num = n % len;
        // 创建 stringBuilder
        StringBuilder sb = new StringBuilder();
        // 添加前 n 个字符外的字符
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i));
        }
        // 添加前 n 个字符
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }*/


    // 字符拼接
    public String reverseLeftWords(String s, int n) {

        int len = s.length();
        String res = "";

        for (int i = n; i < len; i++) {
            res += s.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            res += s.charAt(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
