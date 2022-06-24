<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>配送信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  配送信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${peisongxinxi.gonghao}</td>     <td width='11%'>密码：</td><td width='39%'>${peisongxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${peisongxinxi.xingming}</td>     <td width='11%'>联系电话：</td><td width='39%'>${peisongxinxi.lianxidianhua}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${peisongxinxi.shenfenzheng}</td>     <td width='11%'>地址：</td><td width='39%'>${peisongxinxi.dizhi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

