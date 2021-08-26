//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 532 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);

                if(windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {

                if(valid == need.size()) {
                    res.add(left);
                }

                char rem = s.charAt(left);
                left++;
                if(need.containsKey(rem)) {

                    if(need.get(rem).equals(windows.get(rem))) {
                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 0) - 1);
                }
            }
        }

        return res;
    }*/


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;

            if (needs.containsKey(ch)) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (windows.get(ch).equals(needs.get(ch))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    res.add(left);
                }

                char rem = s.charAt(left);
                left++;
                if (needs.containsKey(rem)) {

                    if (windows.get(rem).equals(needs.get(rem))) {
                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 0) - 1);
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
