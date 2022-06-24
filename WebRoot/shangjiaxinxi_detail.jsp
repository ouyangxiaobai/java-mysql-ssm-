<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>商家信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  商家信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>账号：</td><td width='39%'>${shangjiaxinxi.zhanghao}</td>     <td width='11%'>密码：</td><td width='39%'>${shangjiaxinxi.mima}</td></tr><tr>     <td width='11%'>商家名称：</td><td width='39%'>${shangjiaxinxi.shangjiamingcheng}</td>     <td width='11%'>负责人：</td><td width='39%'>${shangjiaxinxi.fuzeren}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${shangjiaxinxi.dianhua}</td>     <td width='11%'>营业号码：</td><td width='39%'>${shangjiaxinxi.yingyehaoma}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${shangjiaxinxi.dizhi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

