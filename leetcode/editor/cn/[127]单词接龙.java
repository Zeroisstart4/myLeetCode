//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 759 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //把字典中的单词放入到set中，主要是为了方便查询
        Set<String> dicSet = new HashSet<>(wordList);
        //创建一个新的单词，记录单词是否被访问过，如果没被访问过就加入进来
        Set<String> visit = new HashSet<>();
        //BFS中常见的队列，我们可以把它想象成为一颗二叉树，记录每一层的节点。
        //或者把它想象成为一个图，记录挨着的节点，也就是每一圈的节点。这里我们把它想象成为一个图
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //这里的图是一圈一圈往外扩散的，这里的minlen可以看做扩散了多少圈，
        //也就是最短的转换序列长度
        int minlen = 1;
        while (!queue.isEmpty()) {
            //这里找出每个节点周围的节点数量，然后都遍历他们
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //出队
                String word = queue.poll();
                //这里遍历每一个节点的单词，然后修改其中一个字符，让他成为一个新的单词，
                //并查看这个新的单词在字典中是否存在，如果存在并且没有被访问过，就加入到队列中
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if(c == chars[j]) {
                            continue;
                        }
                        chars[j] = c;
                        //修改其中的一个字符，然后重新构建一个新的单词
                        String newWord = String.valueOf(chars);
                        //查看字典中有没有这个单词，如果有并且没有被访问过，就加入到队列中
                        //（Set的add方法表示把单词加入到队列中，如果set中没有这个单词
                        //就会添加成功，返回true。如果有这个单词，就会添加失败，返回false）
                        if(dicSet.contains(newWord) && visit.add(newWord)) {
                            //如果新单词是endWord就返回,这里访问的是第minlen圈的节点，然后
                            //新建的节点就是第minlen+1层
                            if(newWord.equals(endWord)) {
                                return minlen + 1;
                            }

                            queue.add(newWord);
                        }
                    }
                }
            }
            //每往外扩一圈，长度就加1
            minlen++;
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
