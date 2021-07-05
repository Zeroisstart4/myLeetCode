//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {

        //  数字位数
        int digit = 1;
        // 起始位
        long start = 1;
        // start -> end 的统计个数
        long count = 9;

        // 当 n 是多位数时
        while (n > count) {
            // 减少 count
            n -= count;
            // 位数 + 1
            digit += 1;
            // 起始位 + 1 位
            start *= 10;
            // 更新 start -> end 的统计个数
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;

        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
