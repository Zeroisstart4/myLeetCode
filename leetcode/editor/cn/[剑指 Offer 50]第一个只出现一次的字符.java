//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 96 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 哈希表
    public char firstUniqChar(String s) {

        // 创建 map 用于记录字符串是否已经添加入 map
        Map<Character, Boolean> map = new HashMap<>();

        // 字符串转为数组
        char[] chars = s.toCharArray();

        // 将字符数组中所有字符都加入 map, 键为字符，值为判断该键是否已经存在于 map 中
        for (char ch :chars){
            map.put(ch, !map.containsKey(ch));
        }

        for (char ch : chars) {
            if(map.get(ch)) {
                return ch;
            }
        }

        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
