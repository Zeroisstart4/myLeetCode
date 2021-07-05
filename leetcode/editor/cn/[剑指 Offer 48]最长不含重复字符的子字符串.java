//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 210 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        // 健壮性判断
        if (s == null) {
            return 0;
        }

        // 最长的不包含重复字符的子字符串长度
        int max = 0;
        // 起始下标
        int start = -1;
        // 用于查重
        HashMap<Character, Integer> map = new HashMap<>();

        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // 获取字符
            char temp = s.charAt(i);
            // 检查是否重复，若发生重复，则更新起始下标
            if(map.containsKey(temp)) {
                start = Math.max(start, map.get(temp));
            }
            // 若不发生重复，则以字符为键，字符对应索引为值，存入 map
            map.put(temp, i);
            // 更新最大长度
            max = Math.max(max, i - start);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
