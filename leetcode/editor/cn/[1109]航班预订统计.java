//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 fi
//rsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// 1 <= bookings.length <= 2 * 104 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 104 
// 
// Related Topics 数组 前缀和 
// 👍 155 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 航班 i 上预订的座位总数
        int[] counter = new int[n];

        // 遍历订单, bookings[i] = [firsti, lasti, seatsi]
        for (int[] booking : bookings) {

            // 统计 firsti 上机人数
            counter[booking[0] - 1] += booking[2];
            // 减去 lasti 处下机的人数
            if (booking[1] < n) {
                counter[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            counter[i] += counter[i - 1];
        }

        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
