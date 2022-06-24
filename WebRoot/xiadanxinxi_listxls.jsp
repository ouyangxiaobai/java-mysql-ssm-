<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiadanxinxihsgb" scope="page" class="com.bean.XiadanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiadanxinxi.xls");
%>
<html>
  <head>
    <title>下单信息</title>
  </head>

  <body >
 <%
			String sql="select * from xiadanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>商品编号</td>    <td align='center' bgcolor='#ebf0f7'>商品名称</td>    <td align='center' bgcolor='#ebf0f7'>商品类别</td>    <td align='center' bgcolor='#ebf0f7'>价格</td>    <td align='center' bgcolor='#ebf0f7'>售卖人</td>    <td align='center' bgcolor='#ebf0f7'>取件地址</td>    <td align='center' bgcolor='#ebf0f7'>收件人</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>地址</td>    <td align='center' bgcolor='#ebf0f7'>下单人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiadanxinxihsgb.getAllXiadanxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shangpinbianhao}</td>    <td>${u.shangpinmingcheng}</td>    <td>${u.shangpinleibie}</td>    <td>${u.jiage}</td>    <td>${u.shoumairen}</td>    <td>${u.qujiandizhi}</td>    <td>${u.shoujianren}</td>    <td>${u.dianhua}</td>    <td>${u.dizhi}</td>    <td>${u.xiadanren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

