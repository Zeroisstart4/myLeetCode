//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 272 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 递归法
    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Set<String> res = new HashSet<>();

        backtrack(chars, "", visited, res);

        return res.toArray(new String[res.size()]);
    }


    /**
     * 回溯
     * @param chars     待排列数组
     * @param temp      待排列数组的一个排列
     * @param visited   记录当前数组元素是否已访问
     * @param res       结果集
     */
    public void backtrack(char[] chars, String temp, boolean[] visited, Set<String> res) {

        // 若字符串长度等于字符数组长度，则该临时字符串为字符数组的一个排列
        if(temp.length() == chars.length) {
            // 将其添加入结果集
            res.add(temp);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 若当前字符已被访问，则跳过本次循环，进行下一轮循环（减枝思想）
            if(visited[i]) {
                continue;
            }

            // 若当前字符未被访问，标记为已被访问
            visited[i] = true;
            // 递归
            backtrack(chars, temp + chars[i], visited, res);
            // 从新将该字符标记为未被访问，用于跳出这一分支
            visited[i] = false;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
