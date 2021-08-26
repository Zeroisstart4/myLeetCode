//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 93 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    // 构建 Node 节点
    class Node {

        // 键值对
        int key;
        int value;

        // 前驱与后继节点
        Node pre;
        Node next;

        // 构造方法
        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    // 当前容量
    private int size;
    // 最大容量
    private int capacity;
    // 缓存
    private HashMap<Integer, Node> cache;
    // 伪首尾节点
    Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();

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

            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(Node node) {

        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {

       node.pre = head;
       node.next = head.next;

       head.next.pre = node;
       head.next = node;
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
