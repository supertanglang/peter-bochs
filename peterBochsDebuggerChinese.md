# 一个专为操作系统开发者与及汇编高手而设的x86-ia32调试器 #

# 什么是Peter-Bochs? #
-它是一个增强型的bochs模拟器,它加入了一些更强大的调试命令,包括超级中断点,

**加入了什么调试命令？**

-sm， sbreak


**命令教程**

|sm `<开始地址>` `<length>` `<值>`|从内存`<开始地址>`到`<开始地址+lenght>`搜索`<值>`,<值>可以是8/16/32位的16进制/8进制值|
|:---------------------------|:----------------------------------------------------------|
|gdt `<开始号码>` `<结束号码>`       |更详细的打印GDT                                                  |

**超级断点**

| sbreak list|列出所有超级断点|
|:-----------|:-------|
| sbreak add `<开始物理地址>` `<结束物理地址>`|如果CPU进入这个内存区域， bochs将停止|
| sbreak add `<寄存器>`|如果寄存器的值变更， bochs将停止. `<寄存器>`可以是eax, ax, ah, cx, ds, si, esp, di|
| sbreak add `<寄存器>` = `<值>`|如果寄存器的值变成你所指定的值, bochs将停止. `<寄存器>`可以是eax, ax, ah, cx, ds , si, esp, di|
| sbreak delete `<号码>`|删除超级中断点 |


[![](http://www.kingofcoders.com/images/KOC_logo2.jpg)](http://www.kingofcoders.com)

[![](http://hk.kingofcoders.com/images/logo/logo.png)](http://hk.kingofcoders.com)