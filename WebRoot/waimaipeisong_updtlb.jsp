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
		<TITLE>修改外卖配送</TITLE>
	    
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
			<form action="updateWaimaipeisong.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改外卖配送<input type="hidden" name="id" value="${waimaipeisong.id}" /></td>
						</tr>
						<tr style='display:none'><td width="200">商品编号：</td><td><input name='shangpinbianhao' type='text' id='shangpinbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">商品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">商品类别：</td><td><input name='shangpinleibie' type='text' id='shangpinleibie' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">售卖人：</td><td><input name='shoumairen' type='text' id='shoumairen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">取件地址：</td><td><input name='qujiandizhi' type='text' id='qujiandizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">下单人：</td><td><input name='xiadanren' type='text' id='xiadanren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">状态：</td><td><input name='zhuangtai' type='text' id='zhuangtai' value='已完成' onblur='' class="form-control" /></td></tr>
		<tr style='display:none'><td width="200">配送人：</td><td><select name='peisongren' id='peisongren' class="form-control"><%=connDbBean.hsggetoption("peisongxinxi","gonghao")%></select></td></tr>
		<tr 3><td width="200">评分：</td><td><input name='pingfen' type='text' id='pingfen' value='' onblur='' class="form-control" /></td></tr>
		<tr 4><td width="200">评语：</td><td><input name='pingyu' type='text' id='pingyu' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shangpinbianhao.value='${waimaipeisong.shangpinbianhao}';</script>
	<script language="javascript">document.form1.shangpinmingcheng.value='${waimaipeisong.shangpinmingcheng}';</script>
	<script language="javascript">document.form1.shangpinleibie.value='${waimaipeisong.shangpinleibie}';</script>
	<script language="javascript">document.form1.jiage.value='${waimaipeisong.jiage}';</script>
	<script language="javascript">document.form1.shoumairen.value='${waimaipeisong.shoumairen}';</script>
	<script language="javascript">document.form1.qujiandizhi.value='${waimaipeisong.qujiandizhi}';</script>
	<script language="javascript">document.form1.shoujianren.value='${waimaipeisong.shoujianren}';</script>
	<script language="javascript">document.form1.dianhua.value='${waimaipeisong.dianhua}';</script>
	<script language="javascript">document.form1.dizhi.value='${waimaipeisong.dizhi}';</script>
	<script language="javascript">document.form1.xiadanren.value='${waimaipeisong.xiadanren}';</script>
	<script language="javascript">document.form1.zhuangtai.value='${waimaipeisong.zhuangtai}';</script>
	<script language="javascript">document.form1.peisongren.value='${waimaipeisong.peisongren}';</script>
	<script language="javascript">document.form1.pingfen.value='${waimaipeisong.pingfen}';</script>
	<script language="javascript">document.form1.pingyu.value='${waimaipeisong.pingyu}';</script>
	
					 </table>
			</form>
   </body>
</html>






