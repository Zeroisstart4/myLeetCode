//还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴
//都要用到。 
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,2,2]
//输出: true
//
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: [3,3,3,3,4]
//输出: false
//
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 注意: 
//
// 
// 给定的火柴长度和在 0 到 10^9之间。 
// 火柴数组的长度不超过15。 
// 
// Related Topics 深度优先搜索 
// 👍 178 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] matchsticks) {

        int total = 0;
        //统计所有火柴的长度
        for (int num : matchsticks) {
            total += num;
        }

        //如果所有火柴的长度不是4的倍数，直接返回false
        if(total == 0 || (total & 3) != 0) {
            return false;
        }

        // 排序
        Arrays.sort(matchsticks);

        return backtrack(matchsticks, matchsticks.length - 1, total >> 2, new int[4]);

    }

    /**
     *
     * @param nums          火柴
     * @param index         当前火柴的位置
     * @param target        正方形的边长
     * @param size          长度为4的数组,分别保存正方形4个边的长度
     * @return
     */
    private boolean backtrack(int[] nums, int index, int target, int[] size) {

        if(index == -1) {
            //如果火柴都访问完了，并且size的4个边的长度都相等，说明是正方形，直接返回true，
            if(size[0] == size[1] && size[1] == size[2] && size[2] == size[3]) {
                return true;
            }
            // 否则返回 false
            return false;
        }

        for (int i = 0; i < size.length; i++) {

            // 如果把当前火柴放到size[i]这个边上，他的长度大于target，或者上一个分支的值和当前分支的一样
            if(size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1])) {
                continue;
            }

            //如果当前火柴放到size[i]这个边上，长度不大于target，我们就放上面
            size[i] += nums[index];

            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if(backtrack(nums, index - 1, target, size)) {
                return true;
            }

            //size[i]这个边上给移除，然后在试其他的边
            size[i] -= nums[index];
        }

        //如果不能构成正方形，直接返回false
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
