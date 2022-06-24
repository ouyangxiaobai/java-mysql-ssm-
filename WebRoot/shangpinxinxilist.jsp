<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>商品信息</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>商品信息</h3>
            </div>
          
		<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="spxxList.do" name="myform" method="post" style="width:100%">
									查询   商品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao" class="form-control2" />  商品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" class="form-control2" />  商品类别：<input name="shangpinleibie" type="text" id="shangpinleibie" class="form-control2" />  售卖人：<input name="shoumairen" type="text" id="shoumairen" class="form-control2" />
									<input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='spxxListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>商品编号</td>    <td bgcolor='#ebf0f7'>商品名称</td>    <td bgcolor='#ebf0f7'>商品类别</td>    <td bgcolor='#ebf0f7'>价格</td>    <td bgcolor='#ebf0f7' width='90' align='center'>图片</td>        <td bgcolor='#ebf0f7'>售卖人</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.shangpinbianhao}</td>    <td>${u.shangpinmingcheng}</td>    <td>${u.shangpinleibie}</td>    <td>${u.jiage}</td>    <td width='90'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>        <td>${u.shoumairen}</td>    
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="spxxDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="spxxList.do?page=1" >首页</a>
             <a href="spxxList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="spxxList.do?page=${page.page+1 }">下一页</a>
			<a href="spxxList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




						  
        </div>
    </section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
  
</body> 
</html>
