# 简介 #

什么是操作系统除错信息协定？
  * 为了方便操作系统开发, 在peter-bochs调试器里显示自定的除错信息, 所以订立此协定.


为什么你可能会喜欢它?
  * 在操作系统开发的最开头时候, 开发者很难像linux一样有自己的procfs, 所以为了方便大家容易点去显示OS里的调试信易, 所以搞了这个协定出来, 只要你OS依从这个小小的协定, 你就能利用peter-bochs调试器去UI化地帮你显示debug资讯, 不需要太过依靠printf了.
  * 这个协定是中性的, 就是说任何操作系统都可以支持, 方便广大的操作系统开发爱好者.

现状
  * 我仍然在开发这个东西，它会在peter-bochs的下一个版本公布。因此，当前版本不支持它。如果你想试用此功能，请从SVN检出源代码，自己在Eclipse编译。或者你可以发电邮给我要求最新的可执行jar文件 mcheung63@hotmail.com，谢谢。

<font color='red>如果你认为这个标准仍然不能满足您的操作系统开发，请在下面添加评论/功能要求</font'>

<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump1.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump1.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump2.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump2.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump3.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump3.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump4.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump4.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump5.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump5.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump6.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump6.png' border='0' width='150' /></a>
<a href='http://peter-bochs.googlecode.com/files/osDebugScreenDump7.png'><img src='http://peter-bochs.googlecode.com/files/osDebugScreenDump7.png' border='0' width='150' /></a>

<h1>你一定要知道的事</h1>

<ul><li>此协定一定要存在在一块连续的内存里.<br>
</li><li>你可以把这快内存放到任何地址.<br>
</li><li>协定的大小不是固定, 它是xml的, 视乎你想显示的信息多少, 所以大少不一.<br>
</li><li>Peter-bochs调试器支持这协定.<br>
</li><li>执行peter-bochs时, 要在内存加入-osdebug来指定协定在内存的那个位置, 例子: -osdebug=0x100000 , peter-bochs于每次中途停止时在内存0x100000里读出这个协定所指的除错信息.</li></ul>

<h1>数据格式</h1>

<table><thead><th><b>偏移</b></th><th><b>字段</b></th><th><b>范例值</b></th><th><b>大小</b></th><th><b>说明</b></th></thead><tbody>
<tr><td>0-7      </td><td>魔术字节     </td><td>PETER---  </td><td>8        </td><td>所有字母大写   </td></tr>
<tr><td>8-11     </td><td>XML的大小   </td><td>          </td><td>4        </td><td>该XML的大小，下面会对XML有所说明</td></tr>
<tr><td>12-N     </td><td>xml      </td><td>

<xml>

....<br>
<br>
</xml><br>
<br>
</td><td>有多大则有多大  </td><td>XML放在這裏  </td></tr></tbody></table>

<h2>XML格式</h2>

<pre><code>&lt;xml&gt;<br>
	&lt;os&gt;<br>
		&lt;name&gt;Peter operating system&lt;/name&gt;<br>
		&lt;uptime&gt;2010/4/22 12:13:45&lt;/uptime&gt;<br>
		&lt;notes&gt;&lt;![CDATA[<br>
		function matchwo(a,b)<br>
{<br>
if (a &lt; b &amp;&amp; a &lt; 0) then<br>
  {<br>
  return 1;<br>
  }<br>
else<br>
  {<br>
  return 0;<br>
  }<br>
}<br>
]]&gt;<br>
		&lt;/notes&gt;<br>
	&lt;/os&gt;<br>
	&lt;kernel&gt;<br>
		&lt;name&gt;SL&lt;/name&gt;<br>
		&lt;version&gt;1&lt;/version&gt;<br>
		&lt;address&gt;0x10000&lt;/address&gt;<br>
		&lt;modules&gt;<br>
			&lt;module&gt;<br>
				&lt;name&gt;interruptEnginer&lt;/name&gt;<br>
				&lt;address&gt;0x12345678&lt;/address&gt;<br>
			&lt;/module&gt;<br>
		&lt;/modules&gt;<br>
		&lt;interrupts&gt;<br>
			&lt;interrupt&gt;<br>
				&lt;no&gt;1&lt;/no&gt;<br>
				&lt;address&gt;0x2345&lt;/address&gt;<br>
				&lt;tssNo&gt;3&lt;/tssNo&gt;<br>
			&lt;/interrupt&gt;<br>
		&lt;/interrupts&gt;<br>
		&lt;memoryAllocator&gt;<br>
			&lt;region&gt;<br>
				&lt;address&gt;0x100&lt;/address&gt;<br>
				&lt;length&gt;0x200&lt;/length&gt;<br>
			&lt;/region&gt;<br>
			&lt;allocatedRegion&gt;<br>
				&lt;region&gt;<br>
					&lt;address&gt;0x100&lt;/address&gt;<br>
					&lt;length&gt;0x200&lt;/length&gt;<br>
					&lt;virtualAddress&gt;0x200&lt;/virtualAddress&gt;<br>
					&lt;process&gt;program.elf&lt;/process&gt;<br>
				&lt;/region&gt;<br>
			&lt;/allocatedRegion&gt;<br>
		&lt;/memoryAllocator&gt;<br>
	&lt;/kernel&gt;<br>
	&lt;libraries&gt;<br>
		&lt;library&gt;<br>
			&lt;name&gt;libc.so&lt;/name&gt;<br>
			&lt;status&gt;loaded&lt;/status&gt;<br>
		&lt;/library&gt;<br>
	&lt;/libraries&gt;<br>
	&lt;processes&gt;<br>
		&lt;process&gt;<br>
			&lt;PID&gt;1&lt;/PID&gt;<br>
			&lt;name&gt;test.elf&lt;/name&gt;<br>
			&lt;tssNo&gt;12&lt;/tssNo&gt;<br>
			&lt;mmap&gt;<br>
				&lt;memory&gt;<br>
					&lt;type&gt;physical&lt;/type&gt;<br>
					&lt;length&gt;0x200&lt;/length&gt;<br>
					&lt;address&gt;0x100&lt;/address&gt;<br>
				&lt;/memory&gt;<br>
			&lt;/mmap&gt;<br>
			&lt;backlink&gt;2&lt;/backlink&gt;<br>
			&lt;status&gt;running&lt;/status&gt;<br>
			&lt;cmdline&gt;XXX&lt;/cmdline&gt;<br>
		&lt;/process&gt;<br>
	&lt;/processes&gt;<br>
&lt;/xml&gt;<br>
</code></pre>

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