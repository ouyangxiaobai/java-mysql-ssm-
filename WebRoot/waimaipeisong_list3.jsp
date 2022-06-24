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
	<TITLE>外卖配送查询</TITLE>
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
							<td colspan="17" background="images/table_header.gif">外卖配送列表</td>
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
								<form action="waimaipeisongList2.do" name="myform" method="post">
									查询   商品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao" class="form-control2" />  商品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2" />  商品类别：<input name="shangpinleibie" type="text" id="shangpinleibie" class="form-control2" />  收件人：<input name="shoujianren" type="text" id="shoujianren" class="form-control2" />  电话：<input name="dianhua" type="text" id="dianhua" class="form-control2" />  状态：<input name="zhuangtai" type="text" id="zhuangtai" class="form-control2" /> 配送人：<select name='peisongren' id='peisongren' class="form-control2"><option value="">所有</option><%=connDbBean.hsggetoption("peisongxinxi","gonghao")%></select>
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>商品编号</td>
    <td align='center' bgcolor='#ebf0f7'>商品名称</td>
    <td align='center' bgcolor='#ebf0f7'>商品类别</td>
    <td align='center' bgcolor='#ebf0f7'>价格</td>
    <td align='center' bgcolor='#ebf0f7'>售卖人</td>
    <td align='center' bgcolor='#ebf0f7'>取件地址</td>
    <td align='center' bgcolor='#ebf0f7'>收件人</td>
    <td align='center' bgcolor='#ebf0f7'>电话</td>
    <td align='center' bgcolor='#ebf0f7'>地址</td>
    <td align='center' bgcolor='#ebf0f7'>下单人</td>
    <td align='center' bgcolor='#ebf0f7'>状态</td>
    <td align='center' bgcolor='#ebf0f7'>配送人</td>
    <td align='center' bgcolor='#ebf0f7'>评分</td>
    <td align='center' bgcolor='#ebf0f7'>评语</td>
    
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
                             <td>${u.shangpinbianhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.shangpinleibie}</td>
    <td>${u.jiage}</td>
    <td>${u.shoumairen}</td>
    <td>${u.qujiandizhi}</td>
    <td>${u.shoujianren}</td>
    <td>${u.dianhua}</td>
    <td>${u.dizhi}</td>
    <td>${u.xiadanren}</td>
    <td>${u.zhuangtai}</td>
    <td>${u.peisongren}</td>
    <td>${u.pingfen}</td>
    <td>${u.pingyu}</td>
    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"><a class="btn btn-info btn-small" href="doUpdateWaimaipeisonglb.do?id=${u.id }">评价</a> <a class="btn btn-info btn-small" href="waimaipeisongDetail.do?id=${u.id }">详细</a></td>
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
              <a href="waimaipeisongList2.do?page=1" >首页</a>
             <a href="waimaipeisongList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="waimaipeisongList2.do?page=${page.page+1 }">下一页</a>
			<a href="waimaipeisongList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
