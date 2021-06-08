//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 226 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    // 创建入队列栈与出队列栈
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public CQueue() {
        // 初始化栈
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }
    
    public void appendTail(int value) {
        // 将元素添加入入队列栈
        inStack.push(value);
    }
    
    public int deleteHead() {
        // 若出队列栈中为空，则将当前入队列栈的所有元素添加入出队列栈
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        // 若出队列栈为空，返回 - 1
        // 若出队列栈不为空，弹出栈顶元素
        return outStack.isEmpty() ? -1 : outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
