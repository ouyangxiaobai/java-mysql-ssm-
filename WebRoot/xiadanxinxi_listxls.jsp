<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiadanxinxihsgb" scope="page" class="com.bean.XiadanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiadanxinxi.xls");
%>
<html>
  <head>
    <title>�µ���Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from xiadanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>��Ʒ���</td>    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>    <td align='center' bgcolor='#ebf0f7'>��Ʒ���</td>    <td align='center' bgcolor='#ebf0f7'>�۸�</td>    <td align='center' bgcolor='#ebf0f7'>������</td>    <td align='center' bgcolor='#ebf0f7'>ȡ����ַ</td>    <td align='center' bgcolor='#ebf0f7'>�ռ���</td>    <td align='center' bgcolor='#ebf0f7'>�绰</td>    <td align='center' bgcolor='#ebf0f7'>��ַ</td>    <td align='center' bgcolor='#ebf0f7'>�µ���</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

