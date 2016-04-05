# Introduction #

Bochs command line debugger supports single step trace, but I think this is nor enough for OS debugger. So I enhanced it with

![http://peter-bochs.googlecode.com/files/super_step.png](http://peter-bochs.googlecode.com/files/super_step.png)

1) "Step 10 instructions" means execute 10 instructions

2) "Until call or jump" means stop after execute a call or a jump instruction, include je/jne/jl/jgt/etc...

3) "Until IP big change" means stop after IP has a big change. I love this feature, this help me to trace wired bug.



After the bochs is pause, remember to take a look the history window, it keeps all the past record of registers and tables.

![http://peter-bochs.googlecode.com/files/history_table.png](http://peter-bochs.googlecode.com/files/history_table.png)

![http://peter-bochs.googlecode.com/files/history_table2.png](http://peter-bochs.googlecode.com/files/history_table2.png)