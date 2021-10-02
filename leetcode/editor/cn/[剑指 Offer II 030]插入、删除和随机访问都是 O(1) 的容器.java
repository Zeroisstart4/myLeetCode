import java.util.*;

/**
<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构：</p>

<ul>
	<li><code>insert(val)</code>：当元素 <code>val</code> 不存在时返回 <code>true</code>&nbsp;，并向集合中插入该项，否则返回 <code>false</code> 。</li>
	<li><code>remove(val)</code>：当元素 <code>val</code> 存在时返回 <code>true</code>&nbsp;，并从集合中移除该项，否则返回 <code>false</code>&nbsp;。</li>
	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有&nbsp;<strong>相同的概率&nbsp;</strong>被返回。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 :</strong></p>

<pre>
<strong>输入: </strong>inputs = [&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
[[], [1], [2], [2], [], [1], [2], []]
<strong>输出: </strong>[null, true, false, true, 2, true, false, 2]
<strong>解释:
</strong>RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入

randomSet.remove(2); // 返回 false，表示集合中不存在 2 

randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2] 

randomSet.getRandom(); // getRandom 应随机返回 1 或 2 
  
randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2] 

randomSet.insert(2); // 2 已在集合中，所以返回 false 

randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong><meta charset="UTF-8" /></p>

<ul>
	<li><code>-2<sup>31</sup>&nbsp;&lt;= val &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
	<li>最多进行<code> 2 * 10<sup>5</sup></code> 次&nbsp;<code>insert</code> ， <code>remove</code> 和 <code>getRandom</code> 方法调用</li>
	<li>当调用&nbsp;<code>getRandom</code> 方法时，集合中至少有一个元素</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 380&nbsp;题相同：<a href="https://leetcode-cn.com/problems/insert-delete-getrandom-o1/">https://leetcode-cn.com/problems/insert-delete-getrandom-o1/</a></p>
<div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>哈希表</li><li>数学</li><li>随机化</li></div></div><br><div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

    // 键为 val, 值为 val 在 list 中的索引
    Map<Integer, Integer> dict;
    // 存储数据用
    List<Integer> list;
    // 计算随机数
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {

        dict = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        // 若已有该数
        if (dict.containsKey(val)) {
            return false;
        }

        // 存入字典
        dict.put(val, list.size());
        // 在 list.size 处添加 val
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        // 若不存在该数
        if (!dict.containsKey(val)) {
            return false;
        }

        // 获取 list 的末尾元素，用于覆盖 val
        int lastElement = list.get(list.size() - 1);
        // 获取 val 所在的索引
        int index = dict.get(val);

        list.set(index, lastElement);
        dict.put(lastElement, index);

        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
