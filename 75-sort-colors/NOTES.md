互换这种题，注意遍历的边界，换完了，就别继续往下走了.
​
while(p <= j){小于等于，不是小于。边界条件真烦。为啥呢，因为这里的j不能保证是排序的。
​
While curr <= p2 :
​
If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.
​
If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.
​
If nums[curr] = 1 : move pointer curr to the right.
​
其实就是快速排序，但是三色导致的优化使得细节很麻烦。
​
比如指针是从左往右的，但是排序是从两头开始的。如果左边排好则需要移动左指针和当前指针，右边排好则只需要移动右指针，如果是中间值，左右都没法排，那么移动当前指针继续下一位