//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 输入："AAABBC"
//输出：188
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
// Related Topics 回溯算法 
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTilePossibilities(String tiles) {

        char[] chars = tiles.toCharArray();
        //统计每个字符的数量
        int[] count = new int[26];
        for (char ch : chars) {
            count[ch - 'A']++;
        }

        // 结果数组
        int[] res = new int[1];

        // 递归
        backtrack(res, count);

        return res[0];
    }

    private void backtrack(int[] res, int[] arr) {

        //遍历所有的字符
        for (int i = 0; i < arr.length; i++) {

            //如果当前字符使用完了再查找下一个
            if(arr[i] == 0) {
                continue;
            }

            //如果没使用完就继续使用，然后把这个字符的数量减1
            arr[i]--;

            //使用一个字符，子集数量就会多一个
            res[0]++;
            backtrack(res, arr);

            //当前字符使用完之后，把它的数量还原
            arr[i]++;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
