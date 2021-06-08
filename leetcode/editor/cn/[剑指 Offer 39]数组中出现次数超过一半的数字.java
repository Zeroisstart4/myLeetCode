//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 149 👎 0




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {

        // 投票数
        int votes = 0;
        // 众数
        int res = 0;

        for (int num : nums) {
            // 发起投票
            if(votes == 0) {
                res = num;
            }

            // 若该数与 res 相同，则投赞成票 用 1 表示；否则投反对票，用 -1 表示
            votes += num == res ? 1 : -1;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
