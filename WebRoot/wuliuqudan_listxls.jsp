<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wuliuqudanhsgb" scope="page" class="com.bean.WuliuqudanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wuliuqudan.xls");
%>
<html>
  <head>
    <title>����ȡ��</title>
  </head>

  <body >
 <%
			String sql="select * from wuliuqudan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>�������</td>    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>    <td align='center' bgcolor='#ebf0f7'>��Ʒ����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>�ܼ�</td>    <td align='center' bgcolor='#ebf0f7'>ȡ����ַ</td>    <td align='center' bgcolor='#ebf0f7'>�ռ���</td>    <td align='center' bgcolor='#ebf0f7'>�绰</td>    <td align='center' bgcolor='#ebf0f7'>��ַ</td>    <td align='center' bgcolor='#ebf0f7'>�µ���</td>    <td align='center' bgcolor='#ebf0f7'>״̬</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>��ϵ�绰</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

