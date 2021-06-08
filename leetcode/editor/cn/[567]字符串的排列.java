//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 353 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows =new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {

            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {

                if(valid == need.size()) {
                    return true;
                }

                char rem = s2.charAt(left);
                left++;

                if(need.containsKey(rem)) {

                    if(windows.get(rem).equals(need.get(rem))) {
                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 0) - 1);
                }
            }

        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
