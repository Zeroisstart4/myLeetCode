//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 213 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        // 字符串数组
        String[] strs = new String[nums.length];
        // 将数字转为字符串，并存入字符串数组
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 数组排序，排序规则为 字符串 1 + 字符串 2 的字面量 < 字符串 2 + 字符串 1 的字面量
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        // 用于添加字符串
        StringBuilder res = new StringBuilder();
        // 遍历
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
