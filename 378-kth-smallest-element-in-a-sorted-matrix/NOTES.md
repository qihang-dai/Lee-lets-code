
优先级队列默认是小顶堆， (a,b) -> a -b; 互换为大顶堆。

The heap approach is like merge sorted arrays here.

二分就是确定他的search space。往哪里search。

有按Index的二分，上下界必须分明，防止出现overflow。

而按range的二分，上下界多少点可能无所谓，因为最后总要分到他需要的地方。
