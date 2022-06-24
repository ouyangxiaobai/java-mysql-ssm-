<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>配送服务系统</title>
    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
   <section id='introduce'>
        <div class='container'>
			<div class='head text-center'><h3>商品推荐</h3></div>
            <div class='row'>
			<c:forEach items="${syshangpinxinxi}" var="a">
                <div class='col-xs-12 col-sm-6 col-md-4 col-lg-3 works'><a href="spxxDetail.do?id=${a.id}"><div class='bg'>${a.shangpinmingcheng}</div><div class='tab-content item' data-brief=''><img src="${a.tupian}" alt=''></div></a></div>
			 </c:forEach>
            </div>
        </div>
    </section>

    <section class="wjs_product" id="wjs_product">
        <div class="container">
                <div class="head text-center">
                        <h3>新闻公告</h3>
                        <p>所有新闻公告，应有尽有，只需点击下面的标题即可查看详细信息。</p>
                </div>
           
            <div class="tab-content ">
                <div class="tab-pane active" id="product_nav01">
                    <div class="panel panel-primary mt">
                        <div class="panel-heading">
                            <div style="display:flex">
                                <span class="wjs_icon wjs_icon_news_02 icon-left"></span>
                                <h4 class="panel-title">站内新闻</h4>
                            </div>
                            <div style="display:flex">
                                <span class="wjs_icon wjs_icon_news_02 icon-right"></span>
                                <h4 class="panel-title">下单需知</h4>
                            </div>
                        </div>
                        <div class="panel-body">
                                <div class="panel-body-left">
								<c:forEach items="${syxinwentongzhi1 }" var="a">
                                        <a href="xwtzDetail.do?id=${a.id}"><i class="wjs_icon wjs_icon_news_02"></i> ${fn:substring(a.biaoti, 0, 30)}<span>${fn:substring(a.addtime, 0, 10)}</span></a>
								</c:forEach>
                                       
                                </div>
                                <div class="panel-body-right">
                               <c:forEach items="${syxinwentongzhi2 }" var="b">
                                        <a href="xwtzDetail.do?id=${b.id}"><i class="wjs_icon wjs_icon_news_02"></i> ${fn:substring(b.biaoti, 0, 30)}<span>${fn:substring(b.addtime, 0, 10)}</span></a>
								</c:forEach>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

  <section id='introduce'>
        <div class='container'>
			<div class='head text-center'><h3>会员风彩</h3></div>
            <div class='row'>
			 <c:forEach items="${syyonghuzhuce1}" var="b">
                <div class='col-xs-12 col-sm-6 col-md-4 col-lg-3 works'><a href="yhzcDetail.do?id=${b.id}"><div class='bg'>${b.xingming}</div><div class='tab-content item' data-brief=''><img src="${b.touxiang}" alt=''></div></a></div>
			</c:forEach>
            </div>
        </div>
    </section>

    <section class="wjs_news" id="wjs_news">
        <div class="container">
                <div class="head text-center">
                    <h3>关于我们</h3>
                    <p>以下介绍下文字，请您登陆管理员后台自行修改。</p>
                </div>
            <div class="col-md-12 imgs">
                <ul class="nav nav-tabs">
                    <li class="col-md-6"><img src="qtimages/slide_01_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_02_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_03_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_04_640x340.jpg" class="col-md-12"></li>
                </ul>
            </div>
            <div class="col-md-7">
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                       <%=connDbBean.ensubStr(connDbBean.readzd("dx","content","leibie","关于我们"),185)%> 
                    </div>
                </div>
            </div>
        </div>
    </section>
	<jsp:include page="qtdown.jsp"></jsp:include>
	<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
</body>
</html>