//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1333 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character, String> phoneMap;
    public List<String> letterCombinations(String digits) {

        // 创建结果数组
        List<String> combinations = new ArrayList<>();
        // 健壮性判断
        if(digits == null || digits.length() == 0) {
            return combinations;
        }
        // phoneMap 初始化
        phoneMap = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backTrack(combinations, digits, 0, new StringBuilder());

        return combinations;
    }


    public void backTrack(List<String> combinations, String digits, int index, StringBuilder combination) {

        // 递归中止条件
        if(index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        // 获取数字键
        char digit = digits.charAt(index);
        // 通过数字获取对应的字符串
        String letters = phoneMap.get(digit);
        // 获取字符串长度
        int count = letters.length();

        // 遍历
        for (int i = 0; i < count; i++) {

            // 做出选择
            combination.append(letters.charAt(i));
            // 递归进入下一层
            backTrack(combinations, digits, index + 1, combination);
            // 撤销选择
            combination.deleteCharAt(index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
