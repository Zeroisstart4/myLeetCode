//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {

        // 健壮性判断
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // 记录数组长度
        int len = nums.length;

        // 数组长度为 1 时，没有逆序对
        if(len < 2) {
            return 0;
        }

        int[] temp = new int[len];

        return reversePairs(nums, 0, len - 1, temp);
    }

    /**
     *  逆序对个数
     * @param nums      目标数组
     * @param left      左边界
     * @param right     右边界
     * @param temp      临时数组
     * @return
     */
    public int reversePairs(int[] nums, int left, int right, int[] temp) {

        // 健壮性判断
        if(left >= right) {
            return 0;
        }

        // 计算中间值
        int mid = left + (right - left) / 2; // 防止越界

        // 计算左半边的逆序对数
        int leftPairs = reversePairs(nums, left, mid, temp);
        // 计算右半边的逆序对数
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 若左右半边已有序
        if(nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        // 计算左半边与右半边合并时的逆序对数
        int crossPairs = mergeCount(nums, left, mid, right, temp);

        // 三者相加即为总逆序对数
        return leftPairs + crossPairs + rightPairs;
    }


    /**
     *  计算左半边与右半边合并时的逆序对数
     * @param nums      操作数组
     * @param left      左边界
     * @param mid       中间索引
     * @param right     右边界
     * @param temp      临时数组
     * @return
     */
    public int mergeCount(int[] nums, int left, int mid, int right, int[] temp) {

        // 将 nums 复制给 temp
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 记录起始索引与逆序对个数
        int i = left;
        int j = mid + 1;
        int count = 0;

        // 遍历
        for (int k = left; k <= right; k++) {

            // 若左半边已经复制完毕
            if(i == mid + 1) {
                nums[k] = temp[j];
                j++;
            }
            // 若右半边已经复制完毕
            else if(j == right + 1) {
                nums[k] = temp[i];
                i++;
            }
            // 若左半边与右半边都未复制完毕，且左半边 < 右半边
            else if(temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            // 若左半边与右半边都未复制完毕，且左半边 > 右半边，即发生逆序
            else {
                nums[k] = temp[j];
                j++;
                // 逆序个数 + （mid - i + 1）, 即从 i -> mid 都发生了逆序
                count += (mid - i + 1);
            }
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
