# Introduction #

During operating system development, it is valuable to see when the interrupt happened, because your OS may crash because of interrupt and some interrupts (such as IRQ) fired unpredictably. You can trace the interrupt using peter-bochs with peter-bochs-instrument.

Everybody know bochs built-in debugger can let use viewing the status of the CPU or memory, but some of the information are missed. peter-bochs-instrument improve bochs and bringing more CPU information to peter-bochs.

To compile bochs with peter-bochs-instrument, please download the peter-bochs-instrument here http://code.google.com/p/peter-bochs/downloads/list. Place it in the directory instrument with bochs source, see below:

![http://peter-bochs.googlecode.com/files/interrupt_tutorial1.png](http://peter-bochs.googlecode.com/files/interrupt_tutorial1.png)

Then compile bochs with "./configure --enable-logging --enable-debugger --enable-instrumentation=instrument/peter-bochs-instrument/"

After compiling the bochs, please start peter-bochs and enable the "Profiling feature" (see below)

![http://peter-bochs.googlecode.com/files/interrupt_tutorial2.png](http://peter-bochs.googlecode.com/files/interrupt_tutorial2.png)

OK, All are done, just start peter-bochs and see how it captures the interrupt information (see below). In the bottom-right table, you can see the fired count of each interrupt. The chart in the middle showing you the frequency of interrupt.

![http://peter-bochs.googlecode.com/files/interrupt_tutorial3.png](http://peter-bochs.googlecode.com/files/interrupt_tutorial3.png)


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