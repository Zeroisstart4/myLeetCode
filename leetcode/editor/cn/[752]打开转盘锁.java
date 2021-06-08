//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 死亡列表 deadends 的长度范围为 [1, 500]。 
// 目标数字 target 不会在 deadends 之中。 
// 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。 
// 
// Related Topics 广度优先搜索 
// 👍 253 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> set = new HashSet<>(Arrays.asList(deadends));

        //开始遍历的字符串是"0000"，相当于根节点
        String startStr = "0000";
        if (set.contains(startStr)) {
            return -1;
        }
        //创建队列
        Queue<String> queue = new LinkedList<>();
        //记录访问过的节点
        Set<String> visited = new HashSet<>();
        queue.offer(startStr);
        visited.add(startStr);
        //树的层数
        int level = 0;
        while (!queue.isEmpty()) {
            //每层的子节点个数
            int size = queue.size();

            while (size-- > 0) {
                //每个节点的值
                String str = queue.poll();
                //对于每个节点中的4个数字分别进行加1和减1，相当于创建8个子节点，这八个子节点,可以类比二叉树的左右子节点
                for (int i = 0; i < 4; i++) {

                    char ch = str.charAt(i);
                    //strAdd表示加1的结果，strSub表示减1的结果
                    String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                    String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                    //如果找到直接返回
                    if (str.equals(target)) {
                        return level;
                    }
                    //不能包含死亡数字也不能包含访问过的字符串
                    if (!visited.contains(strAdd) && !set.contains(strAdd)) {
                        queue.offer(strAdd);
                        visited.add(strAdd);
                    }
                    if (!visited.contains(strSub) && !set.contains(strSub)) {
                        queue.offer(strSub);
                        visited.add(strSub);
                    }
                }
            }
            //当前层访问完了，到下一层，层数要加1
            level++;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
