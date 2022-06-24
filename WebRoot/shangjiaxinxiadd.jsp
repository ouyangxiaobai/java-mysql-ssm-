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
    <title>商家信息</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>
<%

  String id="";


 



   %>


	
<script language=javascript >  
function hsgcheck() {
		var zhanghao = $("#zhanghao").val();
		if(zhanghao==""||(zhanghao.length<3||zhanghao.length>12)){
			 $("#clabelzhanghao").html("<font color=red>账号不能为空且长度在3～12位之间！</font>");
			 $("input[id=zhanghao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelzhanghao").html("");
			$.ajax({
				url : "quchongShangjiaxinxi.do",
				type : "post",
				data : "zhanghao=" + zhanghao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelzhanghao").html("<font color=red>账号已存在，请更换！</font>");
					$("input[id=zhanghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelzhanghao").html("系统异常，请检查错误！");
					$("input[id=zhanghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
	<script language="javascript">
function checkform()
{
	var zhanghaoobj = document.getElementById("zhanghao"); if(zhanghaoobj.value==""){document.getElementById("clabelzhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入账号</font>";return false;}else{document.getElementById("clabelzhanghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var shangjiamingchengobj = document.getElementById("shangjiamingcheng"); if(shangjiamingchengobj.value==""){document.getElementById("clabelshangjiamingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入商家名称</font>";return false;}else{document.getElementById("clabelshangjiamingcheng").innerHTML="  "; } 	var fuzerenobj = document.getElementById("fuzeren"); if(fuzerenobj.value==""){document.getElementById("clabelfuzeren").innerHTML="&nbsp;&nbsp;<font color=red>请输入负责人</font>";return false;}else{document.getElementById("clabelfuzeren").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value==""){document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入电话</font>";return false;}else{document.getElementById("clabeldianhua").innerHTML="  "; } 	var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var yingyehaomaobj = document.getElementById("yingyehaoma"); if(yingyehaomaobj.value==""){document.getElementById("clabelyingyehaoma").innerHTML="&nbsp;&nbsp;<font color=red>请输入营业号码</font>";return false;}else{document.getElementById("clabelyingyehaoma").innerHTML="  "; } 	var dizhiobj = document.getElementById("dizhi"); if(dizhiobj.value==""){document.getElementById("clabeldizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入地址</font>";return false;}else{document.getElementById("clabeldizhi").innerHTML="  "; } 	
}
function gow()
{
	document.location.href="shangjiaxinxiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>商家信息</h3>
            </div>
          
		<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addShangjiaxinxi.do" name="form1" method="post">
						<tr ><td width="200">账号：</td><td><input name='zhanghao' type='text' id='zhanghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelzhanghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">商家名称：</td><td><input name='shangjiamingcheng' type='text' id='shangjiamingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshangjiamingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelfuzeren' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeldianhua' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">营业号码：</td><td><input name='yingyehaoma' type='text' id='yingyehaoma' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelyingyehaoma' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabeldizhi' style='margin-top:16px;' /></td></tr>		
		
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
