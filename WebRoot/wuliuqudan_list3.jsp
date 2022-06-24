<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>物流取单查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">物流取单列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="wuliuqudanList2.do" name="myform" method="post">
									查询   物流编号：<input name="wuliubianhao" type="text" id="wuliubianhao" class="form-control2" />  物品名称：<input name="wupinmingcheng" type="text" id="wupinmingcheng" class="form-control2" />  物品类型：<input name="wupinleixing" type="text" id="wupinleixing" class="form-control2" />  收件人：<input name="shoujianren" type="text" id="shoujianren" class="form-control2" />  电话：<input name="dianhua" type="text" id="dianhua" class="form-control2" />  下单人：<input name="xiadanren" type="text" id="xiadanren" class="form-control2" />  工号：<input name="gonghao" type="text" id="gonghao" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>物流编号</td>    <td align='center' bgcolor='#ebf0f7'>物品名称</td>    <td align='center' bgcolor='#ebf0f7'>物品类型</td>    <td align='center' bgcolor='#ebf0f7'>单价</td>    <td align='center' bgcolor='#ebf0f7'>重量</td>    <td align='center' bgcolor='#ebf0f7'>总价</td>    <td align='center' bgcolor='#ebf0f7'>取件地址</td>    <td align='center' bgcolor='#ebf0f7'>收件人</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>地址</td>    <td align='center' bgcolor='#ebf0f7'>下单人</td>    <td align='center' bgcolor='#ebf0f7'>状态</td>    <td align='center' bgcolor='#ebf0f7'>工号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>评价</td>    <td align='center' bgcolor='#ebf0f7'>评语</td>    
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
                             <td>${u.wuliubianhao}</td>    <td>${u.wupinmingcheng}</td>    <td>${u.wupinleixing}</td>    <td>${u.danjia}</td>    <td>${u.zhongliang}</td>    <td>${u.zongjia}</td>    <td>${u.qujiandizhi}</td>    <td>${u.shoujianren}</td>    <td>${u.dianhua}</td>    <td>${u.dizhi}</td>    <td>${u.xiadanren}</td>    <td>${u.zhuangtai}</td>    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td>${u.pingjia}</td>    <td>${u.pingyu}</td>    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"><a class="btn btn-info btn-small" href="doUpdateWuliuqudan.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteWuliuqudan.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="wuliuqudanDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="wuliuqudanList2.do?page=1" >首页</a>
             <a href="wuliuqudanList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="wuliuqudanList2.do?page=${page.page+1 }">下一页</a>
			<a href="wuliuqudanList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
