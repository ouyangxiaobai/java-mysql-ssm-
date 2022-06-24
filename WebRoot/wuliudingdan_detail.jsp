<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>物流订单详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  物流订单详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>物流编号：</td><td width='39%'>${wuliudingdan.wuliubianhao}</td>     <td width='11%'>物品名称：</td><td width='39%'>${wuliudingdan.wupinmingcheng}</td></tr><tr>     <td width='11%'>物品类型：</td><td width='39%'>${wuliudingdan.wupinleixing}</td>     <td width='11%'>单价：</td><td width='39%'>${wuliudingdan.danjia}</td></tr><tr>     <td width='11%'>重量：</td><td width='39%'>${wuliudingdan.zhongliang}</td>     <td width='11%'>总价：</td><td width='39%'>${wuliudingdan.zongjia}</td></tr><tr>     <td width='11%'>取件地址：</td><td width='39%'>${wuliudingdan.qujiandizhi}</td>     <td width='11%'>收件人：</td><td width='39%'>${wuliudingdan.shoujianren}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${wuliudingdan.dianhua}</td>     <td width='11%'>地址：</td><td width='39%'>${wuliudingdan.dizhi}</td></tr><tr>     <td width='11%'>下单人：</td><td width='39%'>${wuliudingdan.xiadanren}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

