//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2415 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        // 记录字符长度
        int len = s.length();

        // 若长度不为偶数，则不可配对
        if(len % 2 != 0) {
            return false;
        }

        // 括号匹配情况表
        Map<Character, Character> pairs = new HashMap<>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
        }};

        // 创建栈
        Deque<Character> stack = new LinkedList<>();
        // 括号依次入栈
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            // 查找是否满足括号匹配情况表，若匹配
            if(pairs.containsKey(ch)) {
                // 若栈为空或者栈顶元素与代入栈元素不匹配
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // 若栈顶元素与代入栈元素匹配
                else {
                    // 弹出栈顶元素
                    stack.pop();
                }
            }
            // 查找是否满足括号匹配情况表，若不匹配
            else {
                // 将当前元素入栈
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    /*public boolean isValid(String s) {

        int n = s.length();
        if ((n & 1) == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (pairs.containsKey(ch)) {

                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
