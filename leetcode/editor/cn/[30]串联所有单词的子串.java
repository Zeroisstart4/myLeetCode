//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 496 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        // 结果数组
        List<Integer> res = new ArrayList<>();
        // 健壮性判断
        if(words == null || words.length == 0) {
            return res;
        }
        // 记录单词数
        int wordNum = words.length;
        // 记录单词长度
        int wordLen = words[0].length();

        // 将所有单词加入 allWords 集合， 键为单词，值为单词出现次数
        Map<String, Integer> allWords = new HashMap<>();
        // 遍历单词集合
        for (String word : words) {
            int value = allWords.getOrDefault(word, 0);
            allWords.put(word, value + 1);
        }

        // 遍历字符串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            // 已经拥有的单词
            Map<String, Integer> hasWords = new HashMap<>();
            // 统计已经匹配的单词数
            int num = 0;

            // 遍历
            while (num < wordNum) {
                // 将字符串截取一段长度为 wordLen 的子串，与 allWords 中的元素进行比较
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                // 若存在，则计数 + 1
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);

                    if(hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                }
                // 若不存在，进行下一轮循环
                else {
                    break;
                }
                // 每添加一个单词，统计数 + 1
                num++;
            }

            // 当完全匹配时，将该索引加入集合
            if (num == wordNum) {
                res.add(i);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
