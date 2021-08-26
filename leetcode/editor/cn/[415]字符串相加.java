//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 377 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;

        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {

            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + add;
            res.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }

        res.reverse();

        return res.toString();

    }

    /*public String addStrings(String num1, String num2) {

        // 记录字符长度
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // 进位
        int carray = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carray != 0) {

            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = i >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carray;

            sb.append(sum % 10);
            carray = sum / 10;

            i--;
            j--;
        }

        sb.reverse();

        return sb.toString();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
