//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 256 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 健壮性判断
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // 创建队列
        Deque<Integer> deque = new LinkedList<>();
        // 创建结果数组
        int[] res = new int[nums.length - k + 1];

        // 形成窗口过程
        for (int i = 0; i < k; i++) {
            // 若队列不为空，且队尾元素比待添加元素小，则将队尾元素移除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            // 添加待添加元素
            deque.addLast(nums[i]);
        }

        // 结果数组首位元素
        res[0] = deque.peekFirst();

        // 窗口移动过程
        for (int i = k; i < nums.length; i++) {
            // 数组向后滚动一位后，数组左边界 + 1，右边界 + 1
            // 若原滚动数组的最大值为 nums[i - k]，则由于数组滚动，会将其丢弃
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            // 若队列不为空，且队尾元素比待添加元素小，则将队尾元素移除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            // 添加待添加元素
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
