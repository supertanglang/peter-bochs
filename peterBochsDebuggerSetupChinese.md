# Steps #

1 ）下载最新的jar http://code.google.com/p/peter-bochs/downloads/list

2 ）检查版本的： java -jar peter-bochs-debugger.jar -v

3 ）运行：

> 在 Linux : java -jar peter-bochs-debugger.jar bochs -f bochsrc.bxrc

> 在 windows : java -jar peter-bochs-debugger.jar c:\program files\bochs2.4.3\bochsdbg.exe -q -f bochsrc.bxrc

> !!! 如果在 windows使用peter-bochs，你需要传递Bochs的exe文件的\*完整路径\*和-q的参数. (!!! 相對路徑是行不通的)

!!! _在parameter上加入-debug才能见到一些没完成的功能_

!!! _在你的bochs设定文件里, 把以下三个值设ignore, 如果设成ask或report, peter-bochs会跑不起来_
```
error: action=ignore
info: action=ignore
debug: action=ignore
```

!!! _如果你在windows下跑peter-bochs, 请安装.net framework 3.5, 因为peter-bochs是呼叫pauseBochs.exe去弄停bochs的, 而这个exe是.net 3.5写成_

备注：请把所有bochs的运行参数放置命令末端

<table border='0'><tr><td>
<a href='http://www.kingofcoders.com'><img src='http://www.kingofcoders.com/images/KOC_logo2.jpg' /></a>
</td><td>
<a href='http://hk.kingofcoders.com'><img src='http://hk.kingofcoders.com/images/logo/logo.png' /></a>
</td>
</tr>
</table>