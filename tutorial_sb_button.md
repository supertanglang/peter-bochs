# Introduction #

In bochs, you can set a breakpoint based on the CPU time(Ptime). It means if CPU do one thing, it increment the ptime by one. This feature is good for OS developer to quickly resume to the state in last crash. Here are the steps to do that in peter-bochs.

# Details #

In the following figure, there are two buttons: SB and SB.

SB button means : Insert a time break point "delta" instructions into the future ("delta" is a 64-bit integer followed by "L", for example 1000L).

SBA button means: Insert a time break point at "time" ("time" is a 64-bit integer followed by "L", for example 1000L).

![http://peter-bochs.googlecode.com/files/tutorial_sb.png](http://peter-bochs.googlecode.com/files/tutorial_sb.png)

Press that button, peter-bochs will ask you for a timestamp you want to break, just input a number in the dialog box (see below)

![http://peter-bochs.googlecode.com/files/tutorial_sb2.png](http://peter-bochs.googlecode.com/files/tutorial_sb2.png)

After the bochs is paused, you can the current ptime (see below)

![http://peter-bochs.googlecode.com/files/tutorial_sb3.png](http://peter-bochs.googlecode.com/files/tutorial_sb3.png)


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