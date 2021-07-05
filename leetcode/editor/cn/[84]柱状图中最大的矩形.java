//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 单调栈 
// 👍 1412 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 单调栈
    public int largestRectangleArea(int[] heights) {

        // 记录数组长度
        int n = heights.length;

        // 左右高度区间
        int[] left = new int[n];
        int[] right = new int[n];

        // 单调栈
        Stack<Integer> stack = new Stack<>();

        // 从左向右遍历
        for (int i = 0; i < n; i++) {
            // 获取可达的最大高度
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 填入 left 数组
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 清空栈
        stack.clear();
        // 从右向左遍历
        for (int i = n - 1; i >= 0; i--) {
            // 获取可达的最大高度
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 填入 right 数组
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 求取最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
