//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 642 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {

        // 零乘任何数都为零
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // 记录数组长度
        int m = num1.length();
        int n = num2.length();

        // 乘法结果数组
        int[] arr = new int[m + n];
        // 从后往前相乘
        for (int i = m - 1; i >= 0; i--) {
            // 字符串 1 的值
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                // 字符串 2 的值
                int y = num2.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }

        // 修改结果值，对值进行进位操作
        for (int i = m + n - 1; i > 0; i--) {
            // 逢十进一
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        // 设置起点，若最后无进位则从第二位开始
        int index = arr[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < m + n) {
            sb.append(arr[index++]);
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
