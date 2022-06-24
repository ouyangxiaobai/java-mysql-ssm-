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
    <title>下单信息</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    
}
function gow()
{
	document.location.href="xiadanxinxiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>下单信息</h3>
            </div>
          
		<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addXiadanxinxi.do" name="form1" method="post">
						<tr ><td width="200">商品编号：</td><td><input name='shangpinbianhao' type='text' id='shangpinbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinbianhao.value='<%=connDbBean.readzd("shangpinxinxi","shangpinbianhao","id",request.getParameter("id"))%>';document.form1.shangpinbianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinmingcheng.value='<%=connDbBean.readzd("shangpinxinxi","shangpinmingcheng","id",request.getParameter("id"))%>';document.form1.shangpinmingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">商品类别：</td><td><input name='shangpinleibie' type='text' id='shangpinleibie' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinleibie.value='<%=connDbBean.readzd("shangpinxinxi","shangpinleibie","id",request.getParameter("id"))%>';document.form1.shangpinleibie.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("shangpinxinxi","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">售卖人：</td><td><input name='shoumairen' type='text' id='shoumairen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shoumairen.value='<%=connDbBean.readzd("shangpinxinxi","shoumairen","id",request.getParameter("id"))%>';document.form1.shoumairen.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">取件地址：</td><td><input name='qujiandizhi' type='text' id='qujiandizhi' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' class="form-control" /></td></tr>
		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeldianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' class="form-control" /></td></tr>
		<tr 0><td width="200">下单人：</td><td><input name='xiadanren' type='text' id='xiadanren' value='<%=(String)request.getSession().getAttribute("username")%>' onblur='' class="form-control" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
						  
        </div>
    </section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
  
</body> 
</html>
