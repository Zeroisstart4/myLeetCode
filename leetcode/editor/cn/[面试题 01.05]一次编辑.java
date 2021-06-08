//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {

        int f = first.length();
        int s = second.length();

        if(Math.abs(f - s) > 1) {
            return false;
        }

        if(first.equals(second)) {
            return true;
        }

        int i = 0, j = 0;
        int count = 0;
        while (i < f && j < s) {

            if(first.charAt(i++) == second.charAt(j++)) {
                continue;
            }

            count++;
            if(count > 1) {
                return false;
            }

            if(f != s) {

                if(f > s) {
                    j--;
                }
                else {
                    i--;
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
