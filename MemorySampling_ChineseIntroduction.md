# 内存取样介绍 #

![http://peter-bochs.googlecode.com/files/Peter-Bochs-Debugger-memorySampling20100702.png](http://peter-bochs.googlecode.com/files/Peter-Bochs-Debugger-memorySampling20100702.png)

## 上图解说 ##

1) 搜寻内存之地址.

2) 主图所表示的开始和结束地址, 如果开始地址设成0x0, 那么主图最左下角的第一个小格就代表内存0x0.

3) 主图中每一小格所表达的内存大小.

4) 主图, 不同的颜色代表不同的存取次数, 越红代表越高, 越蓝代表越低, 灰色代表那一格的内存没被存取过.

5) 当你点击主图内的一小格时, 它的地址和存取次数就会显示在这里.

6) 把主图放大和缩小.

7) 因为主图里的每一格均代表一系列的地址, 当你点击主图的一小格时, 它所代表的每一个内存地址和存取次数, 会在这个表里显示.

<table border='0'><tr><td>
<a href='http://www.kingofcoders.com'><img src='http://www.kingofcoders.com/images/KOC_logo2.jpg' /></a>
</td>
<td>
</td>
<td>
<a href='http://www.rmit.edu.au/compsci'><img src='http://peter-bochs.googlecode.com/files/rmit.gif' /></a>
</td>
</tr>
</table>