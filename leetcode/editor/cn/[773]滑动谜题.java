//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 179 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 各个字符的相邻元素
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {

        // 将 board 数组转为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        // board 初始值
        String initial = sb.toString();
        // 若初始值便已经有序
        if("123450".equals(initial)) {
            return 0;
        }

        // 操作步骤
        int step = 0;
        // BFS 所需队列
        Queue<String> queue = new LinkedList<>();
        // 已经访问序列
        Set<String> seen = new HashSet<>();

        // 添加初始值
        queue.offer(initial);
        seen.add(initial);

        // 开始 BFS
        while (!queue.isEmpty()) {
            // 每遍历一层，则操作步骤 + 1
            step++;
            // 遍历一层
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                // 获取相邻操作
                for (String nextStatus : getList(status)) {
                    if(!seen.contains(nextStatus)) {
                        if("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        // 若遍历所有相邻操作都无法排列为 123450，则返回 -1
        return -1;
    }


    /**
     *      获取通过一次交换可以得到的状态
     * @param status    当前状态
     * @return
     */
    public List<String> getList(String status) {
        // 结果集
        List<String> res = new ArrayList<>();
        // 转字符数组
        char[] array = status.toCharArray();
        // 获取字符 0 所在索引
        int x = status.indexOf('0');
        // 查找字符 ‘0’ 的相邻字符
        for (int y : neighbors[x]) {

            // 交换
            swap(array, x, y);
            // 加入结果集
            res.add(new String(array));
            // 复原
            swap(array,x, y);
        }
        return res;
    }

    // 交换元素
    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
