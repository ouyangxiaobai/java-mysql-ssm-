<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>内容详细</title>
    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
 <%
  String id=request.getParameter("id");
  connDbBean.hsgexecute("update xinwentongzhi set dianjilv=dianjilv+1 where id="+id);
%>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>内容详细</h3>
            </div>
          
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FA8A89" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="46" align="center" class="STYLE1">${xinwentongzhi.biaoti} (被访问${xinwentongzhi.dianjilv }次) </td>
                          </tr>
                          <tr>
                            <td height="110" align="left">${xinwentongzhi.neirong }</td>
                          </tr>
                          <tr>
                            <td height="33" align="right"><input type="button" name="Submit5" value="返回" onClick="javascript:history.back();" ></td>
                          </tr>
                        </table>
						  
        </div>
    </section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
</body>
</html>