# Tutorial : source level debug #

peter-bochs supports c/c++ source level debug, most operating system debugger in the beginning stage is very hard to support source level debug feature, because their kernel may not in ELF format. I believe most people start writing simple kernel in flat binary format. To support source level debug in peter-bochs, just generate a map file for your kernel (eg: $(LD) -Tyour\_linker\_script --print-map > kernel.map) and compile all your source code with -g option, suppose you are using gcc.

The following steps show you how to load your kernel map file and start step over the code.

Step 1) start peter-bochs, click on the "C/C++" button, circle-ed in the following figure. Click "System" -> "load system map" in the menu, then just select your kernel map file
![http://peter-bochs.googlecode.com/files/sourceLevelDebug1.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug1.png)

![http://peter-bochs.googlecode.com/files/sourceLevelDebug2.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug2.png)

Step 2) After waiting for a few seconds, peter-bochs should successfully parsed your kernel.map file and show you the project tree (LHS in the following figure). The project tree contains all the library and object file that construct in your kernel.

![http://peter-bochs.googlecode.com/files/sourceLevelDebug3.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug3.png)

Step 3) Just expand the node, your will see all the functions, in my kernel, the kernel.o file contains detectVesa, dumpXML functions, just click on the function name, it will disassemble that function in the RHS screen. You may ask why all bytes are zero in the RHS screen, it is because bochs stopped at BIOS 0xfffffff0 now. That mean your kernel haven't loaded to the memory yet.

![http://peter-bochs.googlecode.com/files/sourceLevelDebug4.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug4.png)

Step 4), Right click the source code window, click "set physical breakpoint", then run the bochs, you should able to catch the breakpoint.

![http://peter-bochs.googlecode.com/files/sourceLevelDebug5.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug5.png)

Step 5) After the breakpoint is catched, you can see peter-bochs disassemble the assembly code correctly (see below).

![http://peter-bochs.googlecode.com/files/sourceLevelDebug6.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug6.png)

Step 6) you are free the disassemble any function in the library too, just click on the tree node in project tree.

![http://peter-bochs.googlecode.com/files/sourceLevelDebug7.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug7.png)

Step 7) In the "Fucntions" window, it will show all the functions that will loaded to memory. You can double click on any function with a memory address, and then peter-bochs will just disassemble it correctly (see below).

![http://peter-bochs.googlecode.com/files/sourceLevelDebug8.png](http://peter-bochs.googlecode.com/files/sourceLevelDebug8.png)