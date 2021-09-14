//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。 
//
// 
//
// 注意： 
//
// 
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
// 
//
// 示例 2： 
//
// 
//输入：a = 7, b = -3
//输出：0
//解释：7/-3 = truncate(-2.33333..) = -2 
//
// 示例 3： 
//
// 
//输入：a = 0, b = 1
//输出：0 
//
// 示例 4： 
//
// 
//输入：a = 1, b = 1
//输出：1 
//
// 
//
// 提示: 
//
// 
// -231 <= a, b <= 231 - 1 
// b != 0 
// 
//
// 
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/ 
//
// 
// Related Topics 数学 
// 👍 1 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int a, int b) {

        // 结果值
        long result = 0;
        // 被除数
        long x = a;
        // 除数
        long y = b;
        // 是否异号
        boolean negative = (x < 0 && y > 0) || (x > 0 && y < 0);

        // 转为正数
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }

        // 由于 x/y 的结果肯定在[0,x]范围内，所以对x使用二分法
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (quickMulti(mid, y) <= x) {
                // 相乘结果不大于x，左指针右移
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result = negative ? -left : left;

        // 判断是否溢出
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }

    /**
     * 快速乘法
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 积
     */
    public static long quickMulti(long a, long b) {
        long result = 0;

        while (b > 0) {
            if ((b & 1) == 1) {
                // 当前最低位为1，结果里加上a
                result += a;
            }
            // 被乘数右移1位，相当于除以2
            b >>= 1;
            // 乘数倍增，相当于乘以2
            a += a;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
