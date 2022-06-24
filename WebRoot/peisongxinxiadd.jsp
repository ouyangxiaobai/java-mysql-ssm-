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
    <title>配送信息</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>
<%

  String id="";


 



   %>


	
<script language=javascript >  
function hsgcheck() {
		var gonghao = $("#gonghao").val();
		if(gonghao==""||(gonghao.length<3||gonghao.length>12)){
			 $("#clabelgonghao").html("<font color=red>工号不能为空且长度在3～12位之间！</font>");
			 $("input[id=gonghao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelgonghao").html("");
			$.ajax({
				url : "quchongPeisongxinxi.do",
				type : "post",
				data : "gonghao=" + gonghao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelgonghao").html("<font color=red>工号已存在，请更换！</font>");
					$("input[id=gonghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelgonghao").html("系统异常，请检查错误！");
					$("input[id=gonghao]").focus();
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
	var gonghaoobj = document.getElementById("gonghao"); if(gonghaoobj.value==""){document.getElementById("clabelgonghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入工号</font>";return false;}else{document.getElementById("clabelgonghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value==""){document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";return false;}else{document.getElementById("clabellianxidianhua").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value==""){document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入身份证</font>";return false;}else{document.getElementById("clabelshenfenzheng").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      var dizhiobj = document.getElementById("dizhi"); if(dizhiobj.value==""){document.getElementById("clabeldizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入地址</font>";return false;}else{document.getElementById("clabeldizhi").innerHTML="  "; } 	
}
function gow()
{
	document.location.href="peisongxinxiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>配送信息</h3>
            </div>
          
		<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addPeisongxinxi.do" name="form1" method="post">
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelgonghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabellianxidianhua' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshenfenzheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabeldizhi' style='margin-top:16px;' /></td></tr>		
		
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
