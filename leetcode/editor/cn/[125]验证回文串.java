//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 380 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针
    public boolean isPalindrome(String s) {
        // 左右指针
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 消除左侧非数字与字母位
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 消除右侧非数字与字母位
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 忽略大小写，比较数字或字母
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
