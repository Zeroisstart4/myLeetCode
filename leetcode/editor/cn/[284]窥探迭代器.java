import java.util.Iterator;

/**
<p>请你设计一个迭代器，除了支持 <code>hasNext</code> 和 <code>next</code> 操作外，还支持 <code>peek</code> 操作。</p>

<p>实现 <code>PeekingIterator</code> 类：</p>

<div class="original__bRMd">
<div>
<ul>
	<li><code>PeekingIterator(int[] nums)</code> 使用指定整数数组 <code>nums</code> 初始化迭代器。</li>
	<li><code>int next()</code> 返回数组中的下一个元素，并将指针移动到下个元素处。</li>
	<li><code>bool hasNext()</code> 如果数组中存在下一个元素，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
	<li><code>int peek()</code> 返回数组中的下一个元素，但 <strong>不</strong> 移动指针。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
<strong>输出：</strong>
[null, 1, 2, 2, 3, false]

<strong>解释：</strong>
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [<em><strong>1</strong></em>,2,3]
peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,<em><strong>2</strong></em>,3]
peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,<em><strong>2</strong></em>,3]
peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,<em><strong>3</strong></em>]
peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
peekingIterator.hasNext(); // 返回 False
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li>对 <code>next</code> 和 <code>peek</code> 的调用均有效</li>
	<li><code>next</code>、<code>hasNext</code> 和 <code>peek </code>最多调用&nbsp; <code>1000</code> 次</li>
</ul>
</div>
</div>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？</p>
<div><li>👍 114</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator;
	private Integer nextElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
		nextElement = iterator.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ret = nextElement;
		nextElement = iterator.hasNext() ? iterator.next() : null;
		return ret;
	}
	
	@Override
	public boolean hasNext() {
	    return nextElement != null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
