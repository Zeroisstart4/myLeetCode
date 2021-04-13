//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 位运算法
    public boolean isPowerOfTwo(int n) {
        // 若为 0 无需比较，直接返回
        if(n == 0) {
            return false;
        }

        long x = (long) n;
        // 将 x 与 （x-1） 进行按位与操作
        // 这是利用 2 的幂次方数在二进制仅有首位为 1，其余全为 0 ，如 8 ： 1000
        // 而 （2 的幂次方数 - 1） 在二进制仅有首位为 0，其余为 1， 如 7 ： 0111
        // 故2 的幂次方数 x & (x - 1) == 0
        return (x & (x - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
