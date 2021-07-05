//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 298 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {

        // 遍历字符串，统计每个字符出现的频率，同时记录最高频率 maxFreq
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int frequency = map.getOrDefault(ch, 0) + 1;
            map.put(ch, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }

        // 创建桶，存储从 1 到 maxFreq 的每个出现频率的字符；
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            Integer frenquency = entry.getValue();
            for (int i = 0; i < frenquency; i++) {
                buckets[frenquency].append(ch);
            }
        }

        // 按照出现频率从大到小的顺序遍历桶，对于每个出现频率，获得对应的字符，然后将每个字符按照出现频率拼接到排序后的字符串。
        StringBuilder res = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            res.append(buckets[i]);
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
