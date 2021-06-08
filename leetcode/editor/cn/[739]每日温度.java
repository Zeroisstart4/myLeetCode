//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 766 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // 记录数组长度
        int len = temperatures.length;
        // 创建结果数组
        int[] ans = new int[len];
        // 创建单调栈
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {

            // 记录当日温度
            int temp = temperatures[i];
            // 若当前栈不为空，并且当日温度大于栈顶温度时，记录结果值
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {

                // 弹出栈顶元素，其为
                int preIndex = stack.pop();
                // 记录需要等待的天数
                ans[preIndex] = i - preIndex;
            }

            stack.push(i);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
