//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {

        int mask = 0;

        for (char ch : astr.toCharArray()) {

            if((mask & (1 << (ch - 'a'))) != 0) {
                return false;
            }

            mask |= (1 << (ch - 'a'));
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
