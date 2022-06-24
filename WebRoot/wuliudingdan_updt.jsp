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
		<TITLE>修改物流订单</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="wuliudingdan_add.jsp?id=<%=id%>";
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
			<form action="updateWuliudingdan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改物流订单<input type="hidden" name="id" value="${wuliudingdan.id}" /></td>
						</tr>
						<tr ><td width="200">物流编号：</td><td><input name='wuliubianhao' type='text' id='wuliubianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">物品名称：</td><td><input name='wupinmingcheng' type='text' id='wupinmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelwupinmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">物品类型：</td><td><input name='wupinleixing' type='text' id='wupinleixing' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelwupinleixing' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">单价：</td><td><input name='danjia' type='text' id='danjia' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeldanjia' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">重量：</td><td><input name='zhongliang' type='text' id='zhongliang' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelzhongliang' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">总价：</td><td><input name='zongjia' type='text' id='zongjia' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">取件地址：</td><td><input name='qujiandizhi' type='text' id='qujiandizhi' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelqujiandizhi' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshoujianren' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeldianhua' style='margin-top:16px;' /></td></tr>		<tr 0><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabeldizhi' style='margin-top:16px;' /></td></tr>		<tr 1><td width="200">下单人：</td><td><input name='xiadanren' type='text' id='xiadanren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.wuliubianhao.value='${wuliudingdan.wuliubianhao}';</script>	<script language="javascript">document.form1.wupinmingcheng.value='${wuliudingdan.wupinmingcheng}';</script>	<script language="javascript">document.form1.wupinleixing.value='${wuliudingdan.wupinleixing}';</script>	<script language="javascript">document.form1.danjia.value='${wuliudingdan.danjia}';</script>	<script language="javascript">document.form1.zhongliang.value='${wuliudingdan.zhongliang}';</script>	<script language="javascript">document.form1.zongjia.value='${wuliudingdan.zongjia}';</script>	<script language="javascript">document.form1.qujiandizhi.value='${wuliudingdan.qujiandizhi}';</script>	<script language="javascript">document.form1.shoujianren.value='${wuliudingdan.shoujianren}';</script>	<script language="javascript">document.form1.dianhua.value='${wuliudingdan.dianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${wuliudingdan.dizhi}';</script>	<script language="javascript">document.form1.xiadanren.value='${wuliudingdan.xiadanren}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var wupinmingchengobj = document.getElementById("wupinmingcheng"); if(wupinmingchengobj.value==""){document.getElementById("clabelwupinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品名称</font>";return false;}else{document.getElementById("clabelwupinmingcheng").innerHTML="  "; } 	var wupinleixingobj = document.getElementById("wupinleixing"); if(wupinleixingobj.value==""){document.getElementById("clabelwupinleixing").innerHTML="&nbsp;&nbsp;<font color=red>请输入物品类型</font>";return false;}else{document.getElementById("clabelwupinleixing").innerHTML="  "; } 	var danjiaobj = document.getElementById("danjia"); if(danjiaobj.value==""){document.getElementById("clabeldanjia").innerHTML="&nbsp;&nbsp;<font color=red>请输入单价</font>";return false;}else{document.getElementById("clabeldanjia").innerHTML="  "; } 	    var zhongliangobj = document.getElementById("zhongliang"); if(zhongliangobj.value==""){document.getElementById("clabelzhongliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入重量</font>";return false;}else{document.getElementById("clabelzhongliang").innerHTML="  "; } 	    var qujiandizhiobj = document.getElementById("qujiandizhi"); if(qujiandizhiobj.value==""){document.getElementById("clabelqujiandizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入取件地址</font>";return false;}else{document.getElementById("clabelqujiandizhi").innerHTML="  "; } 	var shoujianrenobj = document.getElementById("shoujianren"); if(shoujianrenobj.value==""){document.getElementById("clabelshoujianren").innerHTML="&nbsp;&nbsp;<font color=red>请输入收件人</font>";return false;}else{document.getElementById("clabelshoujianren").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value==""){document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入电话</font>";return false;}else{document.getElementById("clabeldianhua").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var dizhiobj = document.getElementById("dizhi"); if(dizhiobj.value==""){document.getElementById("clabeldizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入地址</font>";return false;}else{document.getElementById("clabeldizhi").innerHTML="  "; } 	var zongjiaj=1;if(document.getElementById("danjia").value!=""){zongjiaj=zongjiaj*parseFloat(document.getElementById("danjia").value);}if(document.getElementById("zhongliang").value!=""){zongjiaj=zongjiaj*parseFloat(document.getElementById("zhongliang").value);}document.getElementById("zongjia").value=zongjiaj;	


return true;   
}   
popheight=450;
</script>  
