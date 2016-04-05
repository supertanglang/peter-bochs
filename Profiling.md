# Table of content #



# Introduction #

Peter-bochs provides profiling feature, you can use it to understand the running behaviour of your hobby os.


# Installation #

To add profiling supprot, you need to compile bochs with instrument feature, please follow the steps

Something you should know:

1) peter-bochs debugger can work with a normal bochs or a bochs with peter-bochs instrument, if your bochs is not compiled with peter-bochs instrument stub, the profiling feature will be disable automatically.

2) if you compile your bochs with peter-bochs instrument, the performance of bochs will around 10% slow (based on my core 2 cuo 2.4 GHz notebook).

3) peter-bochs instrument will not eat much memory, but instead, it will use port 1980 and 1981 to communicate with peter-bochs debugger, make sure these two ports are available.

4) feature request page is here http://code.google.com/p/peter-bochs/wiki/feature

## Step 1, download peter-bochs instrument stub and put it inside the bochs source directory ##

The instruction zip file can be download in here http://code.google.com/p/peter-bochs/downloads/list

![http://peter-bochs.googlecode.com/files/install-peter-bochs-instrument2.png](http://peter-bochs.googlecode.com/files/install-peter-bochs-instrument2.png)

## Step 2, compile bochs with peter-bochs instrument ##

$./configure --enable-disasm --enable-debugger --enable-instrumentation=instrument/peter-bochs-instrument

$make

$make install

# How to use profiling #

## Start peter-bochs with profiling ##

Please click "Setting" on the toolbar, go to "Profiling tab", check all checkboxs. After that, restart the bochs by clicking "Stop bochs" and "Start bochs" button on the toolbar.

![http://peter-bochs.googlecode.com/files/enable_profiling.png](http://peter-bochs.googlecode.com/files/enable_profiling.png)

## Feature 1, you can view which memory has the highest r/w frequency ##

![http://peter-bochs.googlecode.com/files/profiling_memory_rw_count.png](http://peter-bochs.googlecode.com/files/profiling_memory_rw_count.png)

## Feature 2, you can view the r/w count of a specified memory region and what address had accessed those regions ##

![http://peter-bochs.googlecode.com/files/profiling_jmp_count.png](http://peter-bochs.googlecode.com/files/profiling_jmp_count.png)

## Feature 3, you can see the last jumps, and the registers value after a jump ##

![http://peter-bochs.googlecode.com/files/profiling_jmp_table.png](http://peter-bochs.googlecode.com/files/profiling_jmp_table.png)


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