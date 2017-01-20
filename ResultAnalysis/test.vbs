Dim strFilename  
Dim objFSO
Set objFSO = CreateObject("scripting.filesystemobject")  
strFilename = WScript.Arguments.Item(0)
If objFSO.fileexists(strFilename) Then  
  Call Writefile(strFilename)  
Else  
  wscript.echo "no such file!"  
End If  
Set objFSO = Nothing  

Sub Writefile(ByVal strFilename)  
Dim objExcel  
Dim objWB  
Dim objws  

Set objExcel = CreateObject("Excel.Application")  
Set objWB = objExcel.Workbooks.Open(strFilename)  

For Each objws In objWB.Sheets  
  objws.Copy  
  objExcel.ActiveWorkbook.SaveAs objWB.Path & "\" & objws.Name & ".csv", 6  
  objExcel.ActiveWorkbook.Close False  
Next 

objWB.Close False  
objExcel.Quit  
Set objExcel = Nothing  
End Sub  