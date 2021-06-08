//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 105 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // StringBuilder
    /*
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if(ch == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    */

    // 数组法
    public String replaceSpace(String s) {
        // 创建一个是原字符串三倍长的数组，防止原字符串全为空格的情况
        char[] arr = new char[s.length() * 3];
        // 记录该数组的已用长度
        int size = 0;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 若匹配到空格
            if(ch == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            }
            // 若未匹配到空格
            else {
                arr[size++] = ch;
            }
        }
        return new String(arr, 0, size);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
