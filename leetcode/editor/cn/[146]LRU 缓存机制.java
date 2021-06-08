//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1404 👎 0



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    // 创建自制双向链表
    class Node {

        // 键值对
        int key;
        int value;

        // 前驱与后继节点
        Node pre;
        Node next;

        // 构造方法
        public Node() {};
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 缓存
    private Map<Integer, Node> cache = new HashMap<>();
    // 已使用链表长度
    private int size;
    private int capacity;
    private Node head, tail;
    // 容量初始化
    public LRUCache(int capacity) {

        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        // 使用伪头部和伪尾部节点
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        // 如果 key 不存在
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        Node node = cache.get(key);

        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            Node newNode = new Node(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);

            size++;

            if(size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    public void addToHead(Node node) {

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(Node node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(Node node) {

        removeNode(node);
        addToHead(node);
    }

    public Node removeTail() {

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
