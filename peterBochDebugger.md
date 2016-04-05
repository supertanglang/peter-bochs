# What is Peter-Bochs? #
- It is an enhanced bochs emulator with some more debugging commands.

**What debugging commands are added?**

- sm, sbreak, gdt, ldt


**Command tutorial**

|sm `<start address>` `<length>` `<value>`|it will search for the `<value>` start from the `<start address>` to `<start address+lenght>`, `<value>` can be a 8/16/32 bits hex/dec value|
|:----------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------|
|gdt `<starting number>` `<ending number>`|dump the GDT in more detail                                                                                                                 |

**Super breakpoint**

|sbreak list|list out all the super breakpoint|
|:----------|:--------------------------------|
|sbreak add `<starting physical address>` `<ending physical address>`|If the cpu jump into the memory region, bochs will stop|
|sbreak add `<register>`|If the register is changed, bochs will stop. `<register>` can be al, ah, ax, eax, ebx, cx, esi, edi, esp|
|sbreak add `<register>` = `<value>`|If the register value changed to the `<value>` you specified, bochs will stop. `<register>` can be al, ah, ax, eax, ebx, cx, esi, edi, esp|
|sbreak addm `<starting physical address>` `<length>`|If this memory area is modified, bochs will stop|
|sbreak d `<number>`|delete the super breakpoint      |