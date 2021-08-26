//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 702 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 数学法
    /*public int mySqrt(int x) {

        // 健壮性判断
        if (x < 0) {
            return 0;
        }

        // 根号下 x == e ^ (0.5 * log(x));
        int ans = (int) Math.exp(0.5 * Math.log(x));

        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }*/

    // 二分法
    public int mySqrt(int x) {

        // 左右指针
        int left = 0;
        int right = x;
        int res = 0;

        // 二分查找
        while (left <= right) {
            // 计算中间值
            int mid = left + (right - left) / 2;
            // 若中间值平方和小于 x
            if((long) mid * mid <= x) {
                // 更新结果值与左指针
                res = mid;
                left = mid + 1;
            }
            else {
                // 更新右指针
                right = mid - 1;
            }
        }

        return res;
    }


    /*public int mySqrt(int x) {

        int left = 0;
        int rihgt = x;
        int res = 0;

        while (left <= rihgt) {

            int mid = left + (rihgt - left) / 2;

            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else {
                rihgt = mid - 1;
            }
        }

        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
