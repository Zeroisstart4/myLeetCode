//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 
//9，则该函数输出 2。 
//
// 
//
// 示例 1： 
//
// 
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 106 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    /*
    public int hammingWeight(int n) {
        // 记录二进制中的 1 的个数
        int res = 0;
        while (n != 0) {
            // 若为 1，则 res + 1；若为 0，则 res + 0
            res += n & 1;
            // n = n / 2;
            n >>>= 1;
        }
        return res;
    }
    */

    public int hammingWeight(int n) {
        // 记录二进制中的 1 的个数
        int res = 0;

        while (n != 0) {
            // 每循环一次，一的个数 -1
            res++;
            // 每进行一次按位与操作，则消除一个 1
            n &= (n - 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
