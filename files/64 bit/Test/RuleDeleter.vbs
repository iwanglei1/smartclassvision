Set WshShell = CreateObject("WScript.Shell")
WshShell.Run chr(34) & "C:\Test\RuleDeleter.exe" & Chr(34), 0
Set WshShell = Nothing 