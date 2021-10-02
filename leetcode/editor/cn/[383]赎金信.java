/**
<p>给定一个赎金信 (<code>ransom</code>) 字符串和一个杂志(<code>magazine</code>)字符串，判断第一个字符串 <code>ransom</code> 能不能由第二个字符串 <code>magazines</code> 里面的字符构成。如果可以构成，返回 <code>true</code> ；否则返回 <code>false</code>。</p>

<p>(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>ransomNote = "a", magazine = "b"
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>ransomNote = "aa", magazine = "ab"
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>ransomNote = "aa", magazine = "aab"
<strong>输出：</strong>true
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>你可以假设两个字符串均只含有小写字母。</li>
</ul>
<div><li>👍 182</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // 健壮性判断
        if (magazine == null || ransomNote == null || magazine.length() < ransomNote.length()) {
            return false;
        }

        // 基数统计
        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        // 消耗字符
        for (int i = 0; i < ransomNote.length(); i++) {

            if (--count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
