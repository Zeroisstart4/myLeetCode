//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 748 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序
    public List<List<String>> groupAnagrams(String[] strs) {

        // 创建 map
        Map<String, List<String>> map = new HashMap<>();

        // 遍历
        for (String str : strs) {
            // 获取字符串数组
            char[] chars = str.toCharArray();
            // 数组排序
            Arrays.sort(chars);
            // 创建键
            String key = new String(chars);
            // 获取集合
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 添加入集合
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
