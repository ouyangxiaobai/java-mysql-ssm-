 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
 <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
	 	 <form action="hsgloginyanzheng.jsp" method="post" name="userlog" id="userlog" style="display: inline" >
    <div class="modal fade" id="myLoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">登录</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group mb">
                        <span class="input-group-addon" id="basic-addon1">用户名</span>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                    <div class="input-group mb">
                        <span class="input-group-addon" id="basic-addon1">密码</span>
                        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码">
                    </div>
					<div class="input-group mb">
                        <span class="input-group-addon" id="basic-addon1">权限</span>
                       <select name='cx' id='cx' class="form-control">
                                  
<option value='配送'>配送</option>
<option value='商家'>商家</option>
<option value='注册用户'>客户</option>

                                </select>
                    </div>
					<div class="input-group mb">
                        <span class="input-group-addon" id="basic-addon1">验证码</span>
                        <input type="text" class="form-control" id="pagerandom" name="pagerandom" placeholder="验证码">
						<%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" id="yzm" value="<%=yzm %>" >
								   <%=yzm %>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary" onclick="return checklog();">确定</button>
                </div>
            </div>
        </div>
    </div>
	</form>
 <script type="text/javascript">
       
function checklog()
{
	if(document.userlog.username.value=="" || document.userlog.pwd.value=="" || document.userlog.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.userlog.pagerandom.value != document.userlog.yzm.value) {
			alert("验证码错误！");
			document.userlog.pagerandom.focus();
			return false;
	}
	
}
           
                                  </script>
<%}%>