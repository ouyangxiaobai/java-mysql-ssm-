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
		<TITLE>修改物流取单</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="wuliuqudan_add.jsp?id=<%=id%>";
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
			<form action="updateWuliuqudan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改物流取单<input type="hidden" name="id" value="${wuliuqudan.id}" /></td>
						</tr>
						<tr ><td width="200">物流编号：</td><td><input name='wuliubianhao' type='text' id='wuliubianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">物品名称：</td><td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">物品类型：</td><td><input name='wupinleixing' type='text' id='wupinleixing' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">单价：</td><td><input name='danjia' type='text' id='danjia' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">重量：</td><td><input name='zhongliang' type='text' id='zhongliang' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">总价：</td><td><input name='zongjia' type='text' id='zongjia' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">取件地址：</td><td><input name='qujiandizhi' type='text' id='qujiandizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr 0><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr 1><td width="200">下单人：</td><td><input name='xiadanren' type='text' id='xiadanren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr 2><td width="200">状态：</td><td><input name='zhuangtai' type='text' id='zhuangtai' value='' onblur='' class="form-control" /></td></tr>		<tr 3><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.gonghao.value='<%=connDbBean.readzd("peisongxinxi","gonghao","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.gonghao.setAttribute("readOnly",'true');</script>		<tr 4><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("peisongxinxi","xingming","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr 5><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("peisongxinxi","lianxidianhua","gonghao",(String)request.getSession().getAttribute("username"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>		<tr 6><td width="200">评价：</td><td><select name='pingjia' id='pingjia' class="form-control"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option></select></td></tr>		<tr 7><td width="200">评语：</td><td><input name='pingyu' type='text' id='pingyu' value='' onblur='' class="form-control" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.wuliubianhao.value='${wuliuqudan.wuliubianhao}';</script>	<script language="javascript">document.form1.wupinmingcheng.value='${wuliuqudan.wupinmingcheng}';</script>	<script language="javascript">document.form1.wupinleixing.value='${wuliuqudan.wupinleixing}';</script>	<script language="javascript">document.form1.danjia.value='${wuliuqudan.danjia}';</script>	<script language="javascript">document.form1.zhongliang.value='${wuliuqudan.zhongliang}';</script>	<script language="javascript">document.form1.zongjia.value='${wuliuqudan.zongjia}';</script>	<script language="javascript">document.form1.qujiandizhi.value='${wuliuqudan.qujiandizhi}';</script>	<script language="javascript">document.form1.shoujianren.value='${wuliuqudan.shoujianren}';</script>	<script language="javascript">document.form1.dianhua.value='${wuliuqudan.dianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${wuliuqudan.dizhi}';</script>	<script language="javascript">document.form1.xiadanren.value='${wuliuqudan.xiadanren}';</script>	<script language="javascript">document.form1.zhuangtai.value='${wuliuqudan.zhuangtai}';</script>	<script language="javascript">document.form1.gonghao.value='${wuliuqudan.gonghao}';</script>	<script language="javascript">document.form1.xingming.value='${wuliuqudan.xingming}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${wuliuqudan.lianxidianhua}';</script>	<script language="javascript">document.form1.pingjia.value='${wuliuqudan.pingjia}';</script>	<script language="javascript">document.form1.pingyu.value='${wuliuqudan.pingyu}';</script>	
					 </table>
			</form>
   </body>
</html>






