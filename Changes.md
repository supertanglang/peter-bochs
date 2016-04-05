### version 20111224 ###

Added SaveMemoryToXLSDialog

### version 20111120 ###

1) fixed "instruction up", "instruction down" and "instruction down ten" buttons
2) fixed TSS panel exception
3) added option "log to petersoft server"

### version 20111116 ###

1) Added "Run and skip breakpoint for N times"

### version 20110614 ###

1) A better bochs step command http://code.google.com/p/peter-bochs/wiki/SuperStep

### version 20110514 ###

![http://peter-bochs.googlecode.com/files/stepNFeature.png](http://peter-bochs.googlecode.com/files/stepNFeature.png)

### version 20110505 ###

1) Added "Step N" button

### version 20110416 ###

1) Fixed many bugs in openjdk, peter-bochs can run smoothly by using openjdk

### version 20100321 ###

1) can edit memory now

2) all the setting will saved into peter-bochs.xml , using betiwixt library to blind Setting.java into xml.

3) Added "fast step"

4) After type in the bochs command, all panels update automatically

### version 20100217 ###

fixed this bug:

1) when load breakpoint, lbreakpoint will become pbreakpoint

2) instruction "-1" , "-10" call updateBreakpointTableColor()

3) search memory dialog's progress bar still have problem

added these features:

1) added instruction up and down button

### version 20100214 ###

1) fixed : cannot enable/disable the breakpoint that currently catched

2) fixed "hide if address = 0" checkbox is TSSPanel

3) fixed : display wrong field value (P, AVL, G) in LDT

### version 20100207 ###

1) right click popup on breakpoint table can dump/disasseble at breakpoint location

### version 20100118 ###

1) Added DiskPane, can dump the harddisk image

### version 20100101 ###

1) can dump the descriptor in TSS

### version 20091224 ###

fixed these bug:

1) gdt is linear address, not physical address

2) parse TR register value incrorrectly

### version 20091222 ###

1) better TSS dump

### version 20090917 ###

1) dump the ELF

2) fixed the bug on TSS dump

### version 20090914 ###

1) auto update (50%)

2) ELF breakpoint

### version 20090912 ###

1) add text highlight, but not for all registers yet

### version 20090901 ###

1) Added global font size

2) Faster update registers speed