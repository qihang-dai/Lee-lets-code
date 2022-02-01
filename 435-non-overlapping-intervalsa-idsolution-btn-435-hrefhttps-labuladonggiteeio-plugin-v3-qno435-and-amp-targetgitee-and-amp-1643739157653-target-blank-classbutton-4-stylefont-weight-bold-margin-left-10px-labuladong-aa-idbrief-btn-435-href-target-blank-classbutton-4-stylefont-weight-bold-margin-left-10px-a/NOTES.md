
This is a classic template for find the number of non overlapping intervals.

what is overlap??

First we have to sort the array with the start or the end, so at least one side get sorted, the question get simplified( We have more known things now)

if sort by start: **A.start < B.start** < A.end

if sort by end: B.start < **A.end < B.end**

since we want to iterate from the first element, 
 
![image](https://labuladong.gitee.io/algo/images/interval/1.gif)

overlap的判断都是一样的， Cur.start > last.end? then nonoverlap ++;
按end排序，由于start < end， 可以保证之前的每个start和end都在当前的end之前
如果按start排序，会出现第一个区间的end覆盖了所以后面的end的情况，导致必须移除剩余其他区间，并非是最小值。**贪心的核心思想在于局部最优，这里就不是局部最优**。而按end排序，end从小到大，留给下一个start的空间就更大,更有可能塞进去start.

https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0435.%E6%97%A0%E9%87%8D%E5%8F%A0%E5%8C%BA%E9%97%B4.md

一些同学做这道题目可能真的去模拟去重复区间的行为，这是比较麻烦的，还要去删除区间。

题目只是要求移除区间的个数，没有必要去真实的模拟删除区‘

按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的。

按照左边界排序，就要从右向左遍历，因为左边界数值越大越好（越靠右），这样就给前一个区间的空间就越大，所以可以从右向左遍历。’
