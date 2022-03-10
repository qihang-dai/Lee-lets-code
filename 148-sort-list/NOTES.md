O(n logn)不仅是二分，所有二分/分治 基础的算法，比如quicksort和mergesort，都是O(n logn)。
​
对于链表的二分，显然不能直接通过索引。但是找到二分点，中点，只需要快慢指针即可。
​
找中点的快慢指针的fast需要fast.next.next，为了避免null.next，while先检查fast!=null再检查fast.next !=null.对于链表还需要从在mid.prev = null断开上一个表...
​
然后分治二分是种递归，需要basecase。。。