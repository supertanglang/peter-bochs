**!!! I haven't release this feature in last release, it is under stress test, i will release it in oct**

# How Peter-Bochs provides c/c++ source level debug support #
## Introduction ##

In last year, i started to provide c/c++ source level support for Peter-bochs debugger. My first idea is to load a map file, generate by gcc --print-map option. But this idea has many weak points:


1) in mac, linux, cygwin, all their gcc provide different format the the map file, hard to support all of them.

2) in my first idea, even i loaded everything from the map file, i still need to read out all the debug information from dwarf, i was totally look down the dwarf format. I thought dwarf+map file is everything, but i was wrong. ELF header+dwarf is king, they can provide me all information i need for source level debug support.

## peter-bochs current design ##

1) specific your ELF kernel in command line, e.g.:

-loadelf=/path\_to\_your/kernel

the -loadelf option support loading multiple file with specific memory offset, if you want to load multiple files, do this:

-loadelf=/path\_to\_your/kernel=0x100,/path\_to\_your/libpeter.a=0x200

!!! 0x100 is not the absolute memory location, peter-bochs will read out the VirtAddr from the ELF program header in your kernel, then add 0x100 to it. type "readelf -l your\_kernel", you will know what loading address ELF has specified.

2) peter-bochs will call [peter-dwarf](https://code.google.com/p/peter-dwarf/) library to read our all dwarf information

![http://peter-bochs.googlecode.com/files/peter-bochs-loading-dwarf-elf.png](http://peter-bochs.googlecode.com/files/peter-bochs-loading-dwarf-elf.png)

![http://peter-bochs.googlecode.com/files/disasm%20libc.png](http://peter-bochs.googlecode.com/files/disasm%20libc.png)

3) if your kernel are composed with many pieces, such as your own kernel code, your standard libc or some other libraries, make sure you put all debug information from different object file into **one** single dwarf section, take a look my linker script below:

```

ENTRY(start_peter)
SECTIONS
{
	PROVIDE(_GLOBAL_OFFSET_TABLE_ = 0x2000000);
	
	. = 0x1600000;
.rel.dyn :
{
*(.rel.init)
*(.rel.text .rel.text.* .rel.gnu.linkonce.t.*)
*(.rel.fini)
*(.rel.rodata .rel.rodata.* .rel.gnu.linkonce.r.*)
*(.rel.data.rel.ro* .rel.gnu.linkonce.d.rel.ro.*)
*(.rel.data .rel.data.* .rel.gnu.linkonce.d.*)
*(.rel.tdata .rel.tdata.* .rel.gnu.linkonce.td.*)
*(.rel.tbss .rel.tbss.* .rel.gnu.linkonce.tb.*)
*(.rel.ctors)
*(.rel.dtors)
*(.rel.got)
*(.rel.bss .rel.bss.* .rel.gnu.linkonce.b.*)
}

	.kernel : { kernel.o(.text) }
	.pshell : { ../app/pshell/pshell.o(.text) }
	
	.libpeter : { ../library/libpeter/libpeter.a(*) }
	.libc : { libc.a(.text) }
	.libc_peter : { libc_peter.a(.text) }



  /* DWARF debug sections.
     Symbols in the DWARF debugging sections are relative to the beginning
     of the section so we begin them at 0.  */
  /* DWARF 1 */
  .debug          0 : { *(.debug) }
  .line           0 : { *(.line) }
  /* GNU DWARF 1 extensions */
  .debug_srcinfo  0 : { *(.debug_srcinfo) }
  .debug_sfnames  0 : { *(.debug_sfnames) }
  /* DWARF 1.1 and DWARF 2 */
  .debug_aranges  0 : { *(.debug_aranges) }
  .debug_pubnames 0 : { *(.debug_pubnames) }
  /* DWARF 2 */
  .debug_info     0 : { *(.debug_info .gnu.linkonce.wi.*) }
  .debug_abbrev   0 : { *(.debug_abbrev) }
  .debug_line     0 : { *(.debug_line) }
  .debug_frame    0 : { *(.debug_frame) }
  .debug_str      0 : { *(.debug_str) }
  .debug_loc      0 : { *(.debug_loc) }
  .debug_macinfo  0 : { *(.debug_macinfo) }
  /* SGI/MIPS DWARF 2 extensions */
  .debug_weaknames 0 : { *(.debug_weaknames) }
  .debug_funcnames 0 : { *(.debug_funcnames) }
  .debug_typenames 0 : { *(.debug_typenames) }
  .debug_varnames  0 : { *(.debug_varnames) }


/*.everyThingLeft : { *(*) }*/

	PROVIDE(end = .);
	. += 5000;
	
	INCLUDE ../global_linker_script.ls
}
```