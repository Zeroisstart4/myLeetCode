//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 141 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 共享 ans 变量
    int ans = 0;
    public int maxLength(List<String> arr) {

        // 不发生重复的字符串集合，将该字符串转换为二进制数
        List<Integer> uniques = new ArrayList<>();

        // 类似 redis 中的bitMap ，统计每一位上出现的次数
        for (String s : arr) {
            // 字符串转换为二进制数后的值
            int ubique = 0;
            // 遍历每一个字符
            for (int i = 0; i < s.length(); i++) {
                // 将字符转为数字
                int ch = s.charAt(i) - 'a';

                // 若在对应位上已有字符，表示发生重复
                if ((ubique & (1 << ch)) != 0) {
                    // 重置并中止循环
                    ubique = 0;
                    break;
                }

                // 在对应位添加该字符
                ubique |= (1 << ch);

            }

            // 添加不重复字符串
            if (ubique > 0) {
                uniques.add(ubique);
            }
        }

        backTrace(uniques, 0, 0);

        return ans;
    }

    /**
     *  回溯统计不重复组合串长度
     * @param uniques   不重复集合
     * @param size      表示集合的第几位
     * @param unique    不重复字符串的二进制
     */
    public void backTrace(List<Integer> uniques, int size, int unique) {

        // 递归中止条件
        if (size == uniques.size()) {
            // 获取最大字符长度
            ans = Math.max(ans, Integer.bitCount(unique));
            return;
        }

        // 若当前字符串与集合的第 size 位字符串不发生重复
        if ((unique & uniques.get(size)) == 0) {
            // 检查下一位，并将集合的第 size 位字符串中的字符添加入 unique 字符串
            backTrace(uniques, size + 1, unique | uniques.get(size));
        }

        // 若当前字符串与集合的第 size 位字符串发生重复，
        backTrace(uniques, size + 1, unique);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
