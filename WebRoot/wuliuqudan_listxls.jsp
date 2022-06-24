<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wuliuqudanhsgb" scope="page" class="com.bean.WuliuqudanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wuliuqudan.xls");
%>
<html>
  <head>
    <title>物流取单</title>
  </head>

  <body >
 <%
			String sql="select * from wuliuqudan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>物流编号</td>    <td align='center' bgcolor='#ebf0f7'>物品名称</td>    <td align='center' bgcolor='#ebf0f7'>物品类型</td>    <td align='center' bgcolor='#ebf0f7'>单价</td>    <td align='center' bgcolor='#ebf0f7'>重量</td>    <td align='center' bgcolor='#ebf0f7'>总价</td>    <td align='center' bgcolor='#ebf0f7'>取件地址</td>    <td align='center' bgcolor='#ebf0f7'>收件人</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>地址</td>    <td align='center' bgcolor='#ebf0f7'>下单人</td>    <td align='center' bgcolor='#ebf0f7'>状态</td>    <td align='center' bgcolor='#ebf0f7'>工号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>评价</td>    <td align='center' bgcolor='#ebf0f7'>评语</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=wuliuqudanhsgb.getAllWuliuqudan(19);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.wuliubianhao}</td>    <td>${u.wupinmingcheng}</td>    <td>${u.wupinleixing}</td>    <td>${u.danjia}</td>    <td>${u.zhongliang}</td>    <td>${u.zongjia}</td>    <td>${u.qujiandizhi}</td>    <td>${u.shoujianren}</td>    <td>${u.dianhua}</td>    <td>${u.dizhi}</td>    <td>${u.xiadanren}</td>    <td>${u.zhuangtai}</td>    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td>${u.pingjia}</td>    <td>${u.pingyu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

