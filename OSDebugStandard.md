# Introduction #

What is OS debug information standard?
  * To display custom operating system debug information in peter-bochs. If you are developing your own operating system, you probably want to find a easy way to display the debug informations out of the emulator. This document describes the data format of it.

Why you may love it?
  * At the beginning stage of operating system development, it is hard to support procfs. So you may want to find an easy way to display information out of the emulator. That's why I made it for everyone.

Current status
  * I am still developing this thing, it will come on the next version of peter-bochs. So current release doesn't support it yet. If you want to try the latest version, please check out from the SVN and build it in eclipse yourself. Or you can email me mcheung63@hotmail.com for the latest executable jar, thanks.

<font color='red'>If you thing this standard still not satisfy your os dev, please add comment/feature request, thanks first</font>

<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump1.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump1.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump2.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump2.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump3.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump3.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump4.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump4.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump5.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump5.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump6.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump6.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump7.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump7.png' border='0' width='150' /></a>

# You must know #

  * The "OS debug information" stored in a continuous block of memory.
  * You can put this block anywhere in memory.
  * The block size is not fix. It depends on how many information you want to display in peter-bochs
  * Peter-bochs debugger can display the os debug information.
  * You can specify the memory of "debug info" by -osdebug, e.g. : -osdebug=0x100000 , peter-bochs will assume to read physical location 0x100000 everytime it got paused,

# Data format #

|**Offset**|**Field**|**Example value**|**Size**|**Description**|
|:---------|:--------|:----------------|:-------|:--------------|
|0-7       |Magic bytes|PETER---         |8       |All capital letter|
|8-11      |Size of xml|                 |4       |The size of the xml, the format of the xml is described below|
|12-N      |xml      |

&lt;xml&gt;

....

&lt;/xml&gt;

|specified by "Size of xml"|The xml stored here|

## XML format ##

```
<xml>
	<os>
		<name>Peter operating system</name>
		<uptime>2010/4/22 12:13:45</uptime>
		<notes><![CDATA[
		function matchwo(a,b)
{
if (a < b && a < 0) then
  {
  return 1;
  }
else
  {
  return 0;
  }
}
]]>
		</notes>
	</os>
	<kernel>
		<name>SL</name>
		<version>1</version>
		<address>0x10000</address>
		<modules>
			<module>
				<name>interruptEnginer</name>
				<address>0x12345678</address>
			</module>
		</modules>
		<interrupts>
			<interrupt>
				<no>1</no>
				<address>0x2345</address>
				<tssNo>3</tssNo>
			</interrupt>
		</interrupts>
		<memoryAllocator>
			<region>
				<address>0x100</address>
				<length>0x200</length>
			</region>
			<allocatedRegion>
				<region>
					<address>0x100</address>
					<length>0x200</length>
					<virtualAddress>0x200</virtualAddress>
					<process>program.elf</process>
				</region>
			</allocatedRegion>
		</memoryAllocator>
	</kernel>
	<libraries>
		<library>
			<name>libc.so</name>
			<status>loaded</status>
		</library>
	</libraries>
	<processes>
		<process>
			<PID>1</PID>
			<name>test.elf</name>
			<tssNo>12</tssNo>
			<mmap>
				<memory>
					<type>physical</type>
					<length>0x200</length>
					<address>0x100</address>
				</memory>
			</mmap>
			<backlink>2</backlink>
			<status>running</status>
			<cmdline>XXX</cmdline>
		</process>
	</processes>
</xml>
```

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