//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5294 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }*/

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 用与储存滑动窗口覆盖集
        Map<Character, Integer> windows = new HashMap<>();
        // 左右指针与结果值
        int left = 0;
        int right = 0;
        int res = 0;
        // 遍历字符串
        while (right < s.length()) {
            // 获取对应字符
            char c = s.charAt(right);
            right++;
            // 将字符添加入覆盖集，并统计出现次数
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            // 当发生字符重复时
            while (windows.get(c) > 1) {
                // 从左往右缩小滑动窗口
                char rem = s.charAt(left);
                left++;
                windows.put(rem, windows.getOrDefault(rem, 0) - 1);
            }
            // 更新结果值
            res = Math.max(res, right - left);
        }

        return res;
    }

    /*public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> windows = new HashMap<>();

        int left = 0;
        int right = 0;
        int len = s.length();
        int res = 0;

        while (right < len) {

            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while (windows.get(c) > 1) {

                char rem = s.charAt(left);
                left++;
                windows.put(rem, windows.getOrDefault(rem, 0) - 1);
            }

            res = Math.max(res, right - left);
        }

        return res;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
