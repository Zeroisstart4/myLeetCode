//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滑动窗口
    public int longestOnes(int[] nums, int k) {

        // 记录数组长度
        int n = nums.length;
        // 左右指针
        int left = 0;
        int right = 0;
        // 统计 0 个数
        int countZeros = 0;
        // 结果值
        int res = 0;

        // 遍历
        for (right = 0; right < n; right++) {

            // 若右指针指向 0，0 计数 + 1
            if (nums[right] == 0) {
                countZeros++;
            }

            // 当 0 的个数大于 k 时，移动左指针
            while (countZeros > k) {

                if (nums[left++] == 0) {
                    countZeros--;
                }
            }

            // 更新最大值
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
