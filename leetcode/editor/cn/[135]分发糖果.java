//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 555 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {

        int len = ratings.length;

        //记录的是从左往右循环的结果
        int[] left = new int[len];
        //记录的是从右往左循环的结果
        int[] right = new int[len];

        //因为每个孩子至少有一个糖果，默认都给他们一个
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        //统计最少的总共糖果数量
        int total = 0;

        //先从左往右遍历，如果当前孩子的得分比左边的高，那么当前孩子的糖果要比左边孩子的多一个
        for (int i = 1; i < len; i++) {

            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        //然后再从右往左遍历，如果当前孩子的得分比右边的高，那么当前孩子的糖果要比右边边孩子的多一个
        for (int i = len - 1; i > 0; i--) {

            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }

        //要满足左右两边的条件，那么当前孩子的糖果就要取
        //从左往右和从右往左的最大值。
        for (int i = 0; i < len; i++) {
            //累计每个孩子的糖果
            total += Math.max(left[i], right[i]);
        }

        return total;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
