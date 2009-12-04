Option Explicit 

Dim objWMIService, objProcess, colProcess 
Dim strComputer, strProcessKill  
strComputer = "." 
strProcessKill = "'bochsdbg.exe'"   
Set objWMIService = GetObject("winmgmts:" & "{impersonationLevel=impersonate}!\\" & strComputer & "\root\cimv2")   
Set colProcess = objWMIService.ExecQuery("Select * from Win32_Process Where Name = " & strProcessKill ) 



For Each objProcess in colProcess 
       objProcess.Terminate()
   Next

WScript.Quit 