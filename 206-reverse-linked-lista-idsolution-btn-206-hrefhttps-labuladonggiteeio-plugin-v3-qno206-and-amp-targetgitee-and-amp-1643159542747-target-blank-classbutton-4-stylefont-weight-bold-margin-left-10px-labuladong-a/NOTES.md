​Recursive: in recursion you only need to use one parameter, and repeat the process. so the function(head.next) would call recursively untill hit the last Node
cur.next != null, and then you backorder recurse: after hit the last one, then reverse the list: so head.next.next =

iterative: cur != null for cur = cur.next, but i cant go cur.next != null since you need to to go straight to the last node.
if you do cur.next != null, then you wont reverse the last node and the second last node. and encounter **cur.next Null pointer**
error
