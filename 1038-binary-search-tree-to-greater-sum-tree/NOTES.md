首先，我的遍历顺序没问题，就是反过来的中序遍历，先最右，然后中左。
​
问题在于如何记录sum。如果用TreeNode记录，那么这个记录是直接写进内存的，如果用int记录，sum在每一个遍历中都发生了改变。
```
public void util(TreeNode node,int sum){
if(node==null) return;
util(node.right,sum);
sum+=node.val;
node.val=sum;
util(node.left,sum);
}
```
This does NOT work because when **util(node.right,sum)**; change the value of sum, it **will NOT influence the sum in util(node.left,sum);**; while the other code is just the opposite