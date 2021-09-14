import java.util.HashMap;

/**
<div class="title__3Vvk">
<p>运用所掌握的数据结构，设计和实现一个&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (Least Recently Used，最近最少使用) 缓存机制</a> 。</p>

<p>实现 <code>LRUCache</code> 类：</p>

<ul>
	<li><code>LRUCache(int capacity)</code> 以正整数作为容量&nbsp;<code>capacity</code> 初始化 LRU 缓存</li>
	<li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li>
	<li><code>void put(int key, int value)</code>&nbsp;如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
[&quot;LRUCache&quot;, &quot;put&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;get&quot;, &quot;get&quot;]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>输出</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>解释</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
	<li><code>0 &lt;= key &lt;= 10000</code></li>
	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
	<li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li>
</ul>
</div>

<p>&nbsp;</p>

<p><strong>进阶</strong>：是否可以在&nbsp;<code>O(1)</code> 时间复杂度内完成这两种操作？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 146&nbsp;题相同：<a href="https://leetcode-cn.com/problems/lru-cache/">https://leetcode-cn.com/problems/lru-cache/</a>&nbsp;</p>
<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>链表</li><li>双向链表</li></div></div><br><div><li>👍 6</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

	class Node {

		int key;
		int value;

		Node pre;
		Node next;

		public Node() {
		}

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private HashMap<Integer, Node> cache = new HashMap<>();
	private int size;
	private int capcity;
	private Node head;
	private Node tail;
    public LRUCache(int capacity) {

		this.size = 0;
		this.capcity = capacity;
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.pre = head;
    }
    
    public int get(int key) {

		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}
		moveToHead(node);
		return node.value;
	}
    
    public void put(int key, int value) {

		Node node = cache.get(key);
		if (node == null) {

			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			addToHead(newNode);
			size++;

			if (size > capcity) {
				Node rem = removeTail();
				cache.remove(rem.key);
				size--;
			}
		}
		else {
			node.value = value;
			moveToHead(node);
		}
	}

	private void addToHead(Node node) {

		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}

	private void removeNode(Node node) {

		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addToHead(node);
	}

	private Node removeTail() {

		Node res = tail.pre;
		removeNode(res);
		return res;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
