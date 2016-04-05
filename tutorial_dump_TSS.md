# Introduction #

!! This tuttorial teachs you how to dump the TSS's info

Please start peter-bochs, when your OS entered protected mode, pause the "pause button". In the GDT panel (the following diagram), you can see there are TSS entries, please double click it.

![http://peter-bochs.googlecode.com/files/tss_tutorial_1.png](http://peter-bochs.googlecode.com/files/tss_tutorial_1.png)

After double clicked the TSS entry, it will show the TSS panel on the bottom of peter-bochs screen. In this panel, you can see the TSS structure has already dumped out.

![http://peter-bochs.googlecode.com/files/tss_tutorial_2.png](http://peter-bochs.googlecode.com/files/tss_tutorial_2.png)

In the "Info" tab, it show you every bit of the TSS descriptor.

![http://peter-bochs.googlecode.com/files/tss_tutorial_3.png](http://peter-bochs.googlecode.com/files/tss_tutorial_3.png)

In the following "Page Table" tab, it will dumps out all "page directories" and "page tables" pointed by the TSS (Not the page table currently use). You may ask why my page table is empty, it is because my TSS has no page table.
![http://peter-bochs.googlecode.com/files/tss_tutorial_4.png](http://peter-bochs.googlecode.com/files/tss_tutorial_4.png)

If your TSS pointed to a page table, you can do address translate here. Input a virutal address or linear address, it will show you how it will be tranformed to a physical address.
![http://peter-bochs.googlecode.com/files/tss_tutorial_5.png](http://peter-bochs.googlecode.com/files/tss_tutorial_5.png)

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