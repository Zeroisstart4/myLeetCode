//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串 
// 👍 84 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 模拟
    public String compressString(String S) {

        // 空串与单字符串处理
        if (S.length() < 2) {
            return S;
        }
        // 添加字符
        StringBuilder ans = new StringBuilder();
        // 统计重复字符长度
        int count = 1;
        // 当前统计字符
        char ch = S.charAt(0);

        // 从第二个字符开始统计
        for (int i = 1; i < S.length(); i++) {
            // 若发生字符重复，计数 + 1
            if(ch == S.charAt(i)) {
                count++;
            }
            // 若字符不再重复，则将当前统计字符与其统计次数添加入 StringBuilder,并将统计字符修改为下一字符，统计数重置为 1
            else {
                ans.append(ch);
                ans.append(count);
                ch = S.charAt(i);
                count = 1;
            }
        }

        // 最后一个字符需要额外添加
        ans.append(ch);
        ans.append(count);

        return ans.length() < S.length() ? ans.toString() : S;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
