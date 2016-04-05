# How to trace FPU error #

When you developing your OS, if you got a floating point error, it will jump to int 16. Just set a breakpoint on the interrupt handler, when you get there, look at fcs,fip,fdp,fds registers, it will give you some hints.


fip  : Instruction pointer offset

fcs  : Code segment selector

fdp  : Operand pointer offset

fds  : Operand pointer selector


![http://peter-bochs.googlecode.com/files/fpu_bug.png](http://peter-bochs.googlecode.com/files/fpu_bug.png)

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