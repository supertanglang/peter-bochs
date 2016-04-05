# Steps to run peter-bochs-debugger #

1) download the latest jar here http://code.google.com/p/peter-bochs/downloads/list

2) check the version by : java -jar peter-bochs-debugger.jar -v

3) run it :

> In Linux : java -jar peter-bochs-debugger.jar bochs -f bochsrc.bxrc

> In windows : java -jar peter-bochs-debugger.jar c:\program files\bochs2.4.3\bochsdbg.exe -q -f bochsrc.bxrc

> !!! if using peter-bochs in windows, you need to pass the **full path of bochs exe** and **-q** to the parameter. (!!! relative path of bochs exe will not work)

!!! _to use "experimental feature", please add "-debug" to the parameter list_

!!! you have to set the following values to "ignore", if you set it to "ask" or "report", peter-bochs won't run
```
error: action=ignore
info: action=ignore
debug: action=ignore
```


!!! _If you are running peter-bochs in windows, please install .net framework 3.5, it is because peter-bochs execute pauseBochs.exe to pause bochs and that exe is written in .net 3.5._

remarks: please put all the bochs original running parameters at the end of the command

<table border='0'><tr><td>
<a href='http://www.kingofcoders.com'><img src='http://www.kingofcoders.com/images/KOC_logo2.jpg' /></a>
</td><td>
<a href='http://hk.kingofcoders.com'><img src='http://hk.kingofcoders.com/images/logo/logo.png' /></a>
</td>
</tr>
</table>