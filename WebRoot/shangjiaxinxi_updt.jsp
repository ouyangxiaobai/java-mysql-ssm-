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
		<TITLE>修改商家信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shangjiaxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateShangjiaxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改商家信息<input type="hidden" name="id" value="${shangjiaxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">账号：</td><td><input name='zhanghao' type='text' id='zhanghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelzhanghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">商家名称：</td><td><input name='shangjiamingcheng' type='text' id='shangjiamingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshangjiamingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelfuzeren' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeldianhua' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">营业号码：</td><td><input name='yingyehaoma' type='text' id='yingyehaoma' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelyingyehaoma' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabeldizhi' style='margin-top:16px;' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.zhanghao.value='${shangjiaxinxi.zhanghao}';</script>	<script language="javascript">document.form1.mima.value='${shangjiaxinxi.mima}';</script>	<script language="javascript">document.form1.shangjiamingcheng.value='${shangjiaxinxi.shangjiamingcheng}';</script>	<script language="javascript">document.form1.fuzeren.value='${shangjiaxinxi.fuzeren}';</script>	<script language="javascript">document.form1.dianhua.value='${shangjiaxinxi.dianhua}';</script>	<script language="javascript">document.form1.yingyehaoma.value='${shangjiaxinxi.yingyehaoma}';</script>	<script language="javascript">document.form1.dizhi.value='${shangjiaxinxi.dizhi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zhanghaoobj = document.getElementById("zhanghao"); if(zhanghaoobj.value==""){document.getElementById("clabelzhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入账号</font>";return false;}else{document.getElementById("clabelzhanghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var shangjiamingchengobj = document.getElementById("shangjiamingcheng"); if(shangjiamingchengobj.value==""){document.getElementById("clabelshangjiamingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入商家名称</font>";return false;}else{document.getElementById("clabelshangjiamingcheng").innerHTML="  "; } 	var fuzerenobj = document.getElementById("fuzeren"); if(fuzerenobj.value==""){document.getElementById("clabelfuzeren").innerHTML="&nbsp;&nbsp;<font color=red>请输入负责人</font>";return false;}else{document.getElementById("clabelfuzeren").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value==""){document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入电话</font>";return false;}else{document.getElementById("clabeldianhua").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var yingyehaomaobj = document.getElementById("yingyehaoma"); if(yingyehaomaobj.value==""){document.getElementById("clabelyingyehaoma").innerHTML="&nbsp;&nbsp;<font color=red>请输入营业号码</font>";return false;}else{document.getElementById("clabelyingyehaoma").innerHTML="  "; } 	var dizhiobj = document.getElementById("dizhi"); if(dizhiobj.value==""){document.getElementById("clabeldizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入地址</font>";return false;}else{document.getElementById("clabeldizhi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
