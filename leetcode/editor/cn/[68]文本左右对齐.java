/**
<p>给定一个单词数组和一个长度&nbsp;<em>maxWidth</em>，重新排版单词，使其成为每行恰好有&nbsp;<em>maxWidth</em>&nbsp;个字符，且左右两端对齐的文本。</p>

<p>你应该使用&ldquo;贪心算法&rdquo;来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格&nbsp;<code>&#39; &#39;</code>&nbsp;填充，使得每行恰好有 <em>maxWidth</em>&nbsp;个字符。</p>

<p>要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。</p>

<p>文本的最后一行应为左对齐，且单词之间不插入<strong>额外的</strong>空格。</p>

<p><strong>说明:</strong></p>

<ul>
	<li>单词是指由非空格字符组成的字符序列。</li>
	<li>每个单词的长度大于 0，小于等于&nbsp;<em>maxWidth</em>。</li>
	<li>输入单词数组 <code>words</code>&nbsp;至少包含一个单词。</li>
</ul>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
words = [&quot;This&quot;, &quot;is&quot;, &quot;an&quot;, &quot;example&quot;, &quot;of&quot;, &quot;text&quot;, &quot;justification.&quot;]
maxWidth = 16
<strong>输出:</strong>
[
&nbsp; &nbsp;&quot;This &nbsp; &nbsp;is &nbsp; &nbsp;an&quot;,
&nbsp; &nbsp;&quot;example &nbsp;of text&quot;,
&nbsp; &nbsp;&quot;justification. &nbsp;&quot;
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong>
words = [&quot;What&quot;,&quot;must&quot;,&quot;be&quot;,&quot;acknowledgment&quot;,&quot;shall&quot;,&quot;be&quot;]
maxWidth = 16
<strong>输出:</strong>
[
&nbsp; &quot;What &nbsp; must &nbsp; be&quot;,
&nbsp; &quot;acknowledgment &nbsp;&quot;,
&nbsp; &quot;shall be &nbsp; &nbsp; &nbsp; &nbsp;&quot;
]
<strong>解释: </strong>注意最后一行的格式应为 &quot;shall be    &quot; 而不是 &quot;shall     be&quot;,
&nbsp;    因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入:</strong>
words = [&quot;Science&quot;,&quot;is&quot;,&quot;what&quot;,&quot;we&quot;,&quot;understand&quot;,&quot;well&quot;,&quot;enough&quot;,&quot;to&quot;,&quot;explain&quot;,
&nbsp;        &quot;to&quot;,&quot;a&quot;,&quot;computer.&quot;,&quot;Art&quot;,&quot;is&quot;,&quot;everything&quot;,&quot;else&quot;,&quot;we&quot;,&quot;do&quot;]
maxWidth = 20
<strong>输出:</strong>
[
&nbsp; &quot;Science &nbsp;is &nbsp;what we&quot;,
  &quot;understand &nbsp; &nbsp; &nbsp;well&quot;,
&nbsp; &quot;enough to explain to&quot;,
&nbsp; &quot;a &nbsp;computer. &nbsp;Art is&quot;,
&nbsp; &quot;everything &nbsp;else &nbsp;we&quot;,
&nbsp; &quot;do &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&quot;
]
</pre>
<div><div>Related Topics</div><div><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 181</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<String> res;
	public List<String> fullJustify(String[] words, int maxWidth) {
		res = new ArrayList<>();
		int left = 0,right = 0, n = words.length;
		//一直循环知道最后一个单词结束直接返回
		while (true){
			//每次循环后，把右指针赋值给左指针
			left = right;
			//记录每一行可以拿到word的长度和
			int sumLen = 0;
			//判断条件：注意加上字符之间默认的一个空格，默认空格数量为right-left
			while (right < n && sumLen + words[right].length() + right - left <= maxWidth){
				sumLen += words[right++].length();
			}
			//判断是最后一行
			if(right == n){
				StringBuffer sb = new StringBuffer();
				//把最后一行word按照要求输出
				sb.append(appendString(words,left,right," "));
				//末尾添加空格
				sb.append(appendSpace(maxWidth - sb.length()));
				//加入res中并返回
				res.add(sb.toString());
				return res;
			}
			//记录word数量
			int numWords = right - left;
			//记录需要补充空格数量
			int blankSpace = maxWidth - sumLen;
			//如果word为1
			if(numWords == 1){
				//按照要求添加word
				StringBuffer sb = new StringBuffer(words[left]);
				//末尾加入空格
				sb.append(appendSpace(maxWidth - sb.length()));
				//加入res中，进行下一个循环
				res.add(sb.toString());
				continue;
			}
			//记录平均空格数
			int avgSpace = blankSpace/(numWords - 1);
			//记录多出来的空格数
			int extraSpace = blankSpace % (numWords - 1);
			StringBuffer sb = new StringBuffer();
			//多出来的空格数，平均添加到前面
			sb.append(appendString(words, left, left+extraSpace+1, appendSpace(avgSpace + 1)));
			sb.append(appendSpace(avgSpace));
			//剩下的字符正常添加
			sb.append(appendString(words, left+extraSpace+1, right,appendSpace(avgSpace)));
			//加入res中
			res.add(sb.toString());
		}
	}
	//返回长度为n的空格字符串
	public String appendSpace(int n){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}
	//返回word+str+...+word+str+word形式的字符串
	public String appendString(String[] words,int left, int right, String str){
		//拼接第一个word
		StringBuffer sb = new StringBuffer(words[left]);
		//拼接str+word形式
		for (int i = left+1; i < right; i++) {
			sb.append(str);
			sb.append(words[i]);
		}
		return sb.toString();
	}

}
//leetcode submit region end(Prohibit modification and deletion)
