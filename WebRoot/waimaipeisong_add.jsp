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
		<TITLE>添加外卖配送</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="waimaipeisong_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addWaimaipeisong.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加外卖配送</td>
						</tr>
						<tr ><td width="200">商品编号：</td><td><input name='shangpinbianhao' type='text' id='shangpinbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinbianhao.value='<%=connDbBean.readzd("xiadanxinxi","shangpinbianhao","id",request.getParameter("id"))%>';document.form1.shangpinbianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinmingcheng.value='<%=connDbBean.readzd("xiadanxinxi","shangpinmingcheng","id",request.getParameter("id"))%>';document.form1.shangpinmingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">商品类别：</td><td><input name='shangpinleibie' type='text' id='shangpinleibie' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shangpinleibie.value='<%=connDbBean.readzd("xiadanxinxi","shangpinleibie","id",request.getParameter("id"))%>';document.form1.shangpinleibie.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("xiadanxinxi","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">售卖人：</td><td><input name='shoumairen' type='text' id='shoumairen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shoumairen.value='<%=connDbBean.readzd("xiadanxinxi","shoumairen","id",request.getParameter("id"))%>';document.form1.shoumairen.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">取件地址：</td><td><input name='qujiandizhi' type='text' id='qujiandizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.qujiandizhi.value='<%=connDbBean.readzd("xiadanxinxi","qujiandizhi","id",request.getParameter("id"))%>';document.form1.qujiandizhi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shoujianren.value='<%=connDbBean.readzd("xiadanxinxi","shoujianren","id",request.getParameter("id"))%>';document.form1.shoujianren.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.dianhua.value='<%=connDbBean.readzd("xiadanxinxi","dianhua","id",request.getParameter("id"))%>';document.form1.dianhua.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.dizhi.value='<%=connDbBean.readzd("xiadanxinxi","dizhi","id",request.getParameter("id"))%>';document.form1.dizhi.setAttribute("readOnly",'true');</script>
		<tr 0><td width="200">下单人：</td><td><input name='xiadanren' type='text' id='xiadanren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.xiadanren.value='<%=connDbBean.readzd("xiadanxinxi","xiadanren","id",request.getParameter("id"))%>';document.form1.xiadanren.setAttribute("readOnly",'true');</script>
		<tr 1><td width="200">状态：</td><td><input name='zhuangtai' type='text' id='zhuangtai' value='配送中' onblur='' class="form-control" /></td></tr>
		<tr 2><td width="200">配送人：</td><td><select name='peisongren' id='peisongren' class="form-control"><%=connDbBean.hsggetoption("peisongxinxi","gonghao")%></select></td></tr>
		<tr style='display:none'><td width="200">评分：</td><td><input name='pingfen' type='text' id='pingfen' value='' onblur='' class="form-control" /></td></tr>
		<tr style='display:none'><td width="200">评语：</td><td><input name='pingyu' type='text' id='pingyu' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>