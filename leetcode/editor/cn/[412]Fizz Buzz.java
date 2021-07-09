//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// Related Topics 数学 字符串 模拟 
// 👍 99 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {

        // 创建结果数组
        ArrayList<String> res = new ArrayList<>();

        // 遍历
        for (int i = 1; i <= n; i++) {

            boolean time3 = (i % 3 == 0);
            boolean time5 = (i % 5 == 0);

            if (time3 && time5) {
                res.add("FizzBuzz");
            }
            else if (time3) {
                res.add("Fizz");
            }
            else if (time5) {
                res.add("Buzz");
            }
            else {
                res.add(Integer.toString(i));
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
