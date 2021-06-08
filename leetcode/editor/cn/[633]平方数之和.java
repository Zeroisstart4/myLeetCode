//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 239 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针法
    public boolean judgeSquareSum(int c) {

        // 左指针，从零开始
        int left = 0;
        // 右指针，对 c 进行开个号后进行了强制类型转换
        int right = (int) Math.sqrt(c);

        // 开始遍历
        while (left <= right) {
            // 计算左右指针平方和
            int sum = left * left + right * right;

            // 若其平方和签好等于 c，返回 true
            if(sum == c) {
                return true;
            }
            // 若其平方和小于 c，为尽可能的遍历所有结果，则对平方和放大应从小开始，故使左指针 + 1
            else if(sum < c) {
                left++;
            }
            // 若其平方和大于 c，为尽可能的遍历所有结果，则对平方和缩小应从大开始，故使右指针 - 1
            else {
                right--;
            }
        }
        // 不存在这样的结果，返回 false
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
