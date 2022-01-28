overlap : start < end, start1 < end0 && end0 > start1, we have intersection

see the pic:

s---------e 0
  s----e 1
  
s-----e 0 
  s-----e 1
  
   s-----e 0 
 s----------e 1
 
To insert , there are three scenerio:

1. newInterval is before
2. newInterval is after
3. newInterval overlapped.

then when newInterval overlapped other interval, the newInterval changes to bigger newInerval;

So the Algo is;

if overlapped: change the start and end of newInteval

**if new interval is before: ** this part is tricky. So we add NewInterval first, then add the current? its hard to code. We add the newInterval then made the cur be the new

at Last if newInterval is after: add the cur. add the newInterval at last.


The key is we would meet merge point at sometime. merge is simple, how to handle the before and afterwards is tricky. its before the merge point, just add the original interval, if its after the merge point, we need add the newintervals first, and then add the original interval. The hard thing is we only need to add the newInterval for one time. So in a loop, we record the merge end point, and continue another loop. Or more smartly, just add the newInterval and make the cur be the new. I think there would be some questions that we need to addd multiple insert.

  
  
