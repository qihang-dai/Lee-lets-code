
遍历even和odd都很简单，但有个问题，如果提前单独修改odd或者even，会造成另一边没有保持选来的引用顺序
![image](https://user-images.githubusercontent.com/13762187/152704353-3810e694-84c9-4fd5-81d4-b8ac9539a2a8.png)

也就是 odd.next = even, even.next = odd。为了保证原顺序或链接，修改odd.next = odd.next.next之后要保证odd.next/odd.next.next之后的顺序是正常的，所以在一个循环内先修改Odd再修改even的话不会出问题，而分开就有问题了。为了尽量保持原链表的顺序，一定要依次修改。最大能修改的也就是两个节点之间的a.next = b可以断开，也就是说最多只能承担修改一个原地的链接，否则后面的链接就会被扰乱。

刷题的两个技巧： 1. 获得更多的信息。 2.尽量保持原来已知的信息。 做到这两点就可以以最少的时间和空间复杂度得出解法
