<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>外卖配送详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  外卖配送详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>商品编号：</td><td width='39%'>${waimaipeisong.shangpinbianhao}</td>     <td width='11%'>商品名称：</td><td width='39%'>${waimaipeisong.shangpinmingcheng}</td></tr><tr>     <td width='11%'>商品类别：</td><td width='39%'>${waimaipeisong.shangpinleibie}</td>     <td width='11%'>价格：</td><td width='39%'>${waimaipeisong.jiage}</td></tr><tr>     <td width='11%'>售卖人：</td><td width='39%'>${waimaipeisong.shoumairen}</td>     <td width='11%'>取件地址：</td><td width='39%'>${waimaipeisong.qujiandizhi}</td></tr><tr>     <td width='11%'>收件人：</td><td width='39%'>${waimaipeisong.shoujianren}</td>     <td width='11%'>电话：</td><td width='39%'>${waimaipeisong.dianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${waimaipeisong.dizhi}</td>     <td width='11%'>下单人：</td><td width='39%'>${waimaipeisong.xiadanren}</td></tr><tr>     <td width='11%'>状态：</td><td width='39%'>${waimaipeisong.zhuangtai}</td>     <td width='11%'>配送人：</td><td width='39%'>${waimaipeisong.peisongren}</td></tr><tr>     <td width='11%'>评分：</td><td width='39%'>${waimaipeisong.pingfen}</td>     <td width='11%'>评语：</td><td width='39%'>${waimaipeisong.pingyu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

