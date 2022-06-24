<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>物流取单详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  物流取单详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>物流编号：</td><td width='39%'>${wuliuqudan.wuliubianhao}</td>     <td width='11%'>物品名称：</td><td width='39%'>${wuliuqudan.wupinmingcheng}</td></tr><tr>     <td width='11%'>物品类型：</td><td width='39%'>${wuliuqudan.wupinleixing}</td>     <td width='11%'>单价：</td><td width='39%'>${wuliuqudan.danjia}</td></tr><tr>     <td width='11%'>重量：</td><td width='39%'>${wuliuqudan.zhongliang}</td>     <td width='11%'>总价：</td><td width='39%'>${wuliuqudan.zongjia}</td></tr><tr>     <td width='11%'>取件地址：</td><td width='39%'>${wuliuqudan.qujiandizhi}</td>     <td width='11%'>收件人：</td><td width='39%'>${wuliuqudan.shoujianren}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${wuliuqudan.dianhua}</td>     <td width='11%'>地址：</td><td width='39%'>${wuliuqudan.dizhi}</td></tr><tr>     <td width='11%'>下单人：</td><td width='39%'>${wuliuqudan.xiadanren}</td>     <td width='11%'>状态：</td><td width='39%'>${wuliuqudan.zhuangtai}</td></tr><tr>     <td width='11%'>工号：</td><td width='39%'>${wuliuqudan.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${wuliuqudan.xingming}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${wuliuqudan.lianxidianhua}</td>     <td width='11%'>评价：</td><td width='39%'>${wuliuqudan.pingjia}</td></tr><tr>     <td width='11%'>评语：</td><td width='39%'>${wuliuqudan.pingyu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

