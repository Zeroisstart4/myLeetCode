/**
<p><big><small>给定一个二维矩阵 <code>matrix</code>，</small></big>以下类型的多个请求：</p>

<ul>
	<li><big><small>计算其子矩形范围内元素的总和，该子矩阵的左上角为 <code>(row1,&nbsp;col1)</code> ，右下角为 <code>(row2,&nbsp;col2)</code> 。</small></big></li>
</ul>

<p>实现 <code>NumMatrix</code> 类：</p>

<ul>
	<li><code>NumMatrix(int[][] matrix)</code>&nbsp;给定整数矩阵 <code>matrix</code> 进行初始化</li>
	<li><code>int sumRegion(int row1, int col1, int row2, int col2)</code>&nbsp;返回<big><small>左上角</small></big><big><small> <code>(row1,&nbsp;col1)</code>&nbsp;、右下角&nbsp;<code>(row2,&nbsp;col2)</code></small></big>&nbsp;的子矩阵的元素总和。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://pic.leetcode-cn.com/1626332422-wUpUHT-image.png" style="width: 200px;" /></p>

<pre>
<strong>输入:</strong> 
[&quot;NumMatrix&quot;,&quot;sumRegion&quot;,&quot;sumRegion&quot;,&quot;sumRegion&quot;]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
<strong>输出:</strong> 
[null, 8, 11, 12]

<strong>解释:</strong>
NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m,&nbsp;n &lt;=&nbsp;200</code><meta charset="UTF-8" /></li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= matrix[i][j] &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= row1 &lt;= row2 &lt; m</code></li>
	<li><code>0 &lt;= col1 &lt;= col2 &lt; n</code></li>
	<li><meta charset="UTF-8" />最多调用 <code>10<sup>4</sup></code> 次&nbsp;<code>sumRegion</code> 方法</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 304&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/range-sum-query-2d-immutable/">https://leetcode-cn.com/problems/range-sum-query-2d-immutable/</a></p>
<div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>矩阵</li><li>前缀和</li></div></div><br><div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

	// 二维前缀和
	int[][] sum;
    public NumMatrix(int[][] matrix) {

		// 记录数组行列
		int row = matrix.length;
		int col = matrix[0].length;
		// 初始化前缀和数组
		sum = new int[row + 1][col + 1];
		// 构建前缀和数组
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// S(i + 1, j + 1) = S(i + 1, j) + S(i, j + 1) - S(i, j);
				sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
		// sum[(x1, y1) (x2, y2)] = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]
		return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
