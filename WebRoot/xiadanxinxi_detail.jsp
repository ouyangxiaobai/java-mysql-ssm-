<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>下单信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  下单信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>商品编号：</td><td width='39%'>${xiadanxinxi.shangpinbianhao}</td>     <td width='11%'>商品名称：</td><td width='39%'>${xiadanxinxi.shangpinmingcheng}</td></tr><tr>     <td width='11%'>商品类别：</td><td width='39%'>${xiadanxinxi.shangpinleibie}</td>     <td width='11%'>价格：</td><td width='39%'>${xiadanxinxi.jiage}</td></tr><tr>     <td width='11%'>售卖人：</td><td width='39%'>${xiadanxinxi.shoumairen}</td>     <td width='11%'>取件地址：</td><td width='39%'>${xiadanxinxi.qujiandizhi}</td></tr><tr>     <td width='11%'>收件人：</td><td width='39%'>${xiadanxinxi.shoujianren}</td>     <td width='11%'>电话：</td><td width='39%'>${xiadanxinxi.dianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${xiadanxinxi.dizhi}</td>     <td width='11%'>下单人：</td><td width='39%'>${xiadanxinxi.xiadanren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

