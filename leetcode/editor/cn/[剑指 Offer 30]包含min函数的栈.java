//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 125 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */

    // 操作栈
    Stack<Integer> inStack;
    // 最小数栈
    Stack<Integer> minStack;
    public MinStack() {
        inStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {

        // 将其加入操作栈
        inStack.add(x);
        // 若最小数栈为空或者最小数栈的栈顶元素小于 x，则将 x 加入最小数栈
        if(minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        }
    }
    
    public void pop() {
        // 若操作栈弹出元素等于最小栈的栈顶元素，则将其弹出
        if(inStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        // 查看操作栈的栈顶元素
        return inStack.peek();
    }
    
    public int min() {
        // 查看最小数栈的栈顶元素
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
