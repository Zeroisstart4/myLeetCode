//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1172 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        // 统计 t 中字符数
        Map<Character, Integer> need = new HashMap<>();
        // 滚动窗口
        Map<Character, Integer> windows = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 左右指针
        int left = 0;
        int right = 0;
        // 有效个数统计
        int valid = 0;
        // 滚动数组起始下标
        int start = 0;
        // 截取字符长度
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {

            // 获取右指针对应字符
            char c = s.charAt(right);
            // 右指针后移一位
            right++;
            // 若当前字符位 t 拥有字符
            if(need.containsKey(c)) {
                // 将其添加入滚动窗口集合
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                // 对比两个集合中字符 c 的个数，有效值 + 1
                if(windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 若有效值已与所需的有效值相同
            while (valid == need.size()) {
                // 记录起点，与长度
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 移动左指针，提升左边界
                char rem = s.charAt(left);
                left++;

                if(need.containsKey(rem)) {

                    if (need.get(rem).equals(windows.get(rem))) {

                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 1) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
