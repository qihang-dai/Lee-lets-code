1. 淹没法，对一切此类问题适用。淹没是为了在没有visited数组的时候避免走回头路.
​
dfs函数可以不返回值，但是会带着外部的i j 指针移动，非常好！
​
2. 利用题目中战船的特性，只能放横放或者竖着放，那么左上角的成为特征值，只需判断有多少个特征值即可。