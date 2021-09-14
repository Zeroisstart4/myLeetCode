//给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。 
//
// 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。 
//
// 如果无法得到答案，请返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：digits = [8,1,9]
//输出："981"
// 
//
// 示例 2： 
//
// 输入：digits = [8,6,7,1,0]
//输出："8760"
// 
//
// 示例 3： 
//
// 输入：digits = [1]
//输出：""
// 
//
// 示例 4： 
//
// 输入：digits = [0,0,0,0,0,0]
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 10^4 
// 0 <= digits[i] <= 9 
// 返回的结果不应包含不必要的前导零。 
// 
// Related Topics 贪心 数组 动态规划 👍 54 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestMultipleOfThree(int[] digits) {

        int[] count = new int[10];
        int[] modulo = new int[3];
        int sum = 0;

        for (int digit : digits) {
            ++count[digit];
            ++modulo[digit % 3];
            sum += digit;
        }

        int left = 0;
        int rest = 0;
        int mod = sum % 3;

        if (mod == 0) {
            left = rest = 0;
        }
        else {
            if (modulo[mod] >= 1) {
                left = mod;
                rest = 1;
            }
            else {
                left = 2 * mod % 3;
                rest = 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char ch = (char) (i + '0');
            for (int j = 0; j < count[i]; j++) {
                if (rest > 0 && i % 3 == left) {
                    --rest;
                }
                else {
                    sb.append(ch);
                }
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb = new StringBuilder("0");
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
