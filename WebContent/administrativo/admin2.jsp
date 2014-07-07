<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LigueDjá - Suas muambas direto da China</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" />
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap/css/admin.css" />
<script
	src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- The below script Makes IE understand the new html5 tags are there and applies our CSS to it -->
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="admin-panel container">
		<div class="slidebar">
			<div class="logo"></div>
			<ul>
				<li><a href="#dashboard" id="targeted">dashboard</a></li>
				<li><a href="#posts">posts</a></li>
				<li><a href="#media">media</a></li>
				<li><a href="#pages">pages</a></li>
				<li><a href="#links">links</a></li>
				<li><a href="#comments">comments</a></li>
				<li><a href="#widgets">widgets</a></li>
				<li><a href="#plugins">plugins</a></li>
				<li><a href="#users">users</a></li>
				<li><a href="#tools">tools</a></li>
				<li><a href="#settings">settings</a></li>
			</ul>
		</div>
		<div class="main">
			<ul class="topbar clearfix">
				<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				<li><a href="#">p</a></li>
				<li><a href="#">o</a></li>
				<li><a href="#">f</a></li>
				<li><a href="#">n</a></li>
			</ul>
			<div class="mainContent clearfix" >
				<div id="dashboard">
					<h2 class="header">
						<span class="icon"></span>Dashboard
					</h2>
					<div class="monitor">
						<h4>Right Now</h4>
						<div class="clearfix">
							<ul class="content">
								<li>content</li>
								<li class="posts"><span class="count">179</span><a href="">posts</a></li>
								<li class="pages"><span class="count">13</span><a href="">pages</a></li>
								<li class="categories"><span class="count">21</span><a
									href="">categories</a></li>
								<li class="tags"><span class="count">305</span><a href="">tags</a></li>
							</ul>
							<ul class="discussions">
								<li>discussions</li>
								<li class="comments"><span class="count">353</span><a
									href="">comments</a></li>
								<li class="approved"><span class="count">319</span><a
									href="">approved</a></li>
								<li class="pending"><span class="count">0</span><a href="">pending</a></li>
								<li class="spam"><span class="count">34</span><a href="">spam</a></li>
							</ul>
						</div>
						<p>
							Theme <a href="">Twenty Eleven</a> with <a href="">3 widgets</a>
						</p>
					</div>
					
				</div>
				<div id="posts" >
				</div>
				<div id="media">
					<h2 class="header">media</h2>
				</div>
				<div id="pages">
					<h2 class="header">pages</h2>
				</div>
				<div id="links">
					<h2 class="header">links</h2>
				</div>
				<div id="comments">
					<h2 class="header">comments</h2>
				</div>
				<div id="widgets">
					<h2 class="header">widgets</h2>
				</div>
				<div id="plugins">
					<h2 class="header">plugins</h2>
				</div>
				<div id="users">
					<h2 class="header">users</h2>
				</div>
				<div id="tools">
					<h2 class="header">tools</h2>
				</div>
				<div id="settings">
					<h2 class="header">settings</h2>
				</div>
			</div>
			<ul class="statusbar">
				<li><a href=""></a></li>
				<li><a href=""></a></li>
				<li class="profiles-setting"><a href="">s</a></li>
				<li class="logout"><a href="">k</a></li>
			</ul>
		</div>
	</div>
</body>
</html>