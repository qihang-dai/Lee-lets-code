# Lee-lets-code
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub](https://github.com/QasimWani/LeetHub)

3/15 no OA, no interview, 熟能生巧
        
        https://leetcode.com/problems/battleships-in-a-board/submissions/
        void的dfs仍然可以带动指针移动，这非常好。
        dfs是通用模板，想要优化就需要利用题目中给的限制条件，战船的特性：只有左上角的是唯一标识符，判断有多少个左上角即可。
        
        https://leetcode.com/problems/string-compression/
        明显的，需要用多个变量记录位置，也就是用指针的题目，用while随意移动指针比用for loop在固定的速率下变更/更新指针更有效。for loop确实也可以通过continue达到去重跳过子问题，但是并没有while来的直观生动。
        上面在说屁话，for(i<length) 和while(i<length)没区别。不，确实用while的时候感觉指针移动的更直观，因为没有感觉外面的一层在自己动
        
        https://leetcode.com/problems/serialize-and-deserialize-bst/submissions/
        emm序列化二叉树， 就是递归左右子树。这里用了BST的左小右大来判断什么时候需要传回Null作为节点。
  
3/21 发生了什么，这么多天没刷题

https://leetcode.com/problems/moving-average-from-data-stream/submissions/

https://leetcode.com/problems/valid-word-abbreviation/submissions/ 简单模拟 但我不会

https://leetcode.com/problems/find-median-from-data-stream/submissions/ 绝妙利用数据结构的设计

3/28 我知道发生了什么。 发生了555和累和睡觉

https://leetcode.com/problems/most-frequent-subtree-sum/submissions/
