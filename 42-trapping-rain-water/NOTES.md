接雨水的Key: 计算出当前节点左边最大和右边最大高度的柱子的最小值，可以想象一下拿两块木板去截住水。单调栈是按行计算面积， 求当前凹槽的长度是多少。动态规划是按列计算面积，求当前列顶上最高有多少。
​
单调栈多使用while循环维护栈，以保持栈的单调，由单调性可以保证“只要存在就处理，不存在则消失”，如接雨水.
​