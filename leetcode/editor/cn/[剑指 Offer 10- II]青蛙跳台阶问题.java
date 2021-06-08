//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        // 分别表示滚动数组的第一、二、三位
        int first = 1;
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
}
//leetcode submit region end(Prohibit modification and deletion)
