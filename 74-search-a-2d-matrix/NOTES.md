二分的边界条件太几把麻烦了。
来了，就还是 I<=j的时候，需要双闭区间。 i < j则是右开区间。于是右界需要比实际多1.
不一致就会出现二分上的遍历不到/无法收敛。