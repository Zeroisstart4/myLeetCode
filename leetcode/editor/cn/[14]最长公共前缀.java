//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1528 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 健壮性判断
        if(strs == null || strs.length == 0) {
            return "";
        }
        // 数组长度为一，仅有一个元素，无需比较，直接返回
        if(strs.length == 1) {
            return strs[0];
        }
        // 当数组元素为 2 及以上时，
        // 先假设最长公共前缀为第一个元素的完整字符串
        String res = strs[0];
        // 遍历每一个元素
        for (int i = 0; i < strs.length; i++) {
            // 若存在元素不一 res 起始
            if(!strs[i].startsWith(res)) {
                // 则从将第一个元素的完整字符串末尾截去
                res = res.substring(0, res.length() - 1);
                // 在索引为 i 处的元素不满足以 res 起始，而前 (i-1) 的元素满足要求
                // 无需再从头比较，只需从索引为 i 处开始比较
                // 故进行 i-- 操作，使循环再次进入索引为 i 处
                i--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
