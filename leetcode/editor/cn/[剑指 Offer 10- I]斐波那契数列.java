//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滚动数组法
    public int fib(int n) {
        // 分别表示滚动数组的第一、二、三位
        int first = 0;
        int second = 1;
        int third = first + second;
        // 进行数组滚动
        for (int i = 0; i < n; i++) {
            // 计算原数组的第三位
            third = (first + second) % 1000000007;
            // 数组前移一位
            first = second;
            second = third;
        }
        // 返回数组的第一位
        return first;
    }

    /*public int fib(int n) {
        int first  = 0;
        int second = 1;
        int third = first + second;

        for (int i = 0; i < n; i++) {
            third = (first + second) % 1000000007;
            first = second;
            second =third;
        }

        return first;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
