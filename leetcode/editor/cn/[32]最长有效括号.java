//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1320 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 栈
    public int longestValidParentheses(String s) {

        // 结果值
        int ans = 0;
        // 栈
        Deque<Integer> stack = new LinkedList<>();
        // 添加 -1
        stack.push(-1);
        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // 若字符为左括号
            if(s.charAt(i) == '(') {
                // 添加索引
                stack.push(i);
            }
            // 若字符为右括号
            else {
                // 弹出栈顶元素
                stack.pop();

                // 若栈为空，则将 i 压入栈
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                // 若栈不为空，更新结果
                else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
