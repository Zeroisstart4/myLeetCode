//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    int res = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        // 初始化数组
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return res;
    }

    void dfs(int i, int j, int m, int n, int k) {
        // 若发生索引越界，或者该点已经被访问，则结束 dfs
        if(i < 0 || i == m || j < 0 || j == n || visited[i][j]) {
            return;
        }

        // 若发生行坐标和列坐标的数位之和大于 k 的情况，则结束 dfs
        if(getSum(i) + getSum(j) > k) {
            return;
        }

        // 若可经过上面两次判断，则表示该点满足条件要求，且未被访问过，则将该点标记为已访问
        visited[i][j] = true;
        // 可访问点 + 1
        res++;

        // 对该点上下左右进行递归
        dfs(i + 1, j, m, n, k);
        dfs(i - 1, j, m, n, k);
        dfs(i, j + 1, m, n, k);
        dfs(i, j - 1, m, n, k);
    }

    // 对数的每位求和
    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }




/*    int res = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return res;
    }

    private void dfs(int i, int j, int m, int n, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        if (getSum(i) + getSum(j) > k) {
            return;
        }
        visited[i][j] = true;
        res++;

        dfs(i + 1, j, m, n, k);
        dfs(i - 1, j, m, n, k);
        dfs(i, j - 1, m, n, k);
        dfs(i, j + 1, m, n, k);
    }

    private int getSum(int num) {

        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
