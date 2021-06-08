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
        // 排序数组
        int[] temp = new int[nums.length];
        return recur(nums, temp, 0, nums.length - 1);
    }

    public int recur(int[] nums, int[] temp, int left, int right) {
        // 终止条件
        if(left >= right) {
            return 0;
        }

        // 递归划分
        int mid = (left + right) >>> 1;

        // 合并阶段
        int res = recur(nums, temp, left, mid) + recur(nums, temp, mid + 1, right);
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;

        while (i < mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            }
            else {
                res += mid - i + 1;
                temp[t++] = nums[i++];
            }
        }

        //将左边剩余元素填充进temp中
        while(i<=mid){
            res += mid - i + 1;
            temp[t++] = nums[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[t++] = nums[j++];
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
