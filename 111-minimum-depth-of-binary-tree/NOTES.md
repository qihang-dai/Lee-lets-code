​
简单bottom up递归，然后考虑到出现一侧空子树的特殊情况if去重即可

top down 也可以， 但是top down也要考虑一侧出现空子树的情况，考虑叶子节点。 top down就别要返回值了，反正返回值是在参数里头..有返回值和没返回值区别不大。 topdown就是把整棵树遍历一遍，用全局变量求最小的

topdown根本不需要触底返回，要什么返回值？？
