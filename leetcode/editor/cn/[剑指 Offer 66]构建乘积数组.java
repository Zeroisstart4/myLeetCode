//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 125 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {

        // 健壮性判断
        if(a == null || a.length == 0) {
            return new int[0];
        }

        // 结果数组
        int[] res = new int[a.length];
        // 初始化条件
        res[0] = 1;

        int temp = 1;

        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
