//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 50 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // set 查重
    /*public boolean canPermutePalindrome(String s) {

        Set<Character> set = new HashSet<>();

        char[] chars = s.toCharArray();

        for (char ch : chars) {

            if(!set.add(ch)) {
                set.remove(ch);
            }
        }

        return set.size() <= 1;
    }*/


    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];

        int count = 0;

        for (char ch : s.toCharArray()) {

            if((map[ch]++ & 1) == 1) {
                count--;
            }
            else {
                count++;
            }
        }

        return count <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
