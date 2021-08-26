//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {

        // 若次幂为 0，则返回 1
        if(n == 0) {
            return 1;
        }
        // 若次幂小于 0 ，则返回 1 / x 的 - n 次幂
        else if(n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        }
        // 若次幂大于 0 ，则为奇数次幂，则返回 x 乘以 x 的 (n - 1)次幂
        else if((n & 1) == 1) {
            return x * myPow(x, n - 1);
        }
        // 若次幂大于 0 ，则为偶数次幂，则返回 1 / x * x 的 n / 2 次幂
        else {
            return myPow(x * x, n / 2);
        }
    }

    /*public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        }
        else if ((n & 1) == 1) {
            return x * myPow(x, n - 1);
        }
        else {
            return myPow(x * x, n / 2);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
