<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shangjiaxinxihsgb" scope="page" class="com.bean.ShangjiaxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shangjiaxinxi.xls");
%>
<html>
  <head>
    <title>商家信息</title>
  </head>

  <body >
 <%
			String sql="select * from shangjiaxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>账号</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td align='center' bgcolor='#ebf0f7'>商家名称</td>    <td align='center' bgcolor='#ebf0f7'>负责人</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>营业号码</td>    <td align='center' bgcolor='#ebf0f7'>地址</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shangjiaxinxihsgb.getAllShangjiaxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zhanghao}</td>    <td>${u.mima}</td>    <td>${u.shangjiamingcheng}</td>    <td>${u.fuzeren}</td>    <td>${u.dianhua}</td>    <td>${u.yingyehaoma}</td>    <td>${u.dizhi}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shangjiaxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

