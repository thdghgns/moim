<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String userName = "";

	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<header id="header">
	<div class="container">
		<div class="navbar navbar-inverse" role="banner"
			style="width: 500px; height: 100px;">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="/">
						<h1>
							<img src="../images/logo1.png" alt="Moim"> Moim
						</h1>
					</a>
					<div class="search">
						<% if(userName =="") { %>
							<a href="/login" class="fa fa-google-plus"></a>
						<% } else { %>
							<div class="dropdown">
								<a href="#"><span id='current-user'><%=userName%></span></a>
								<div class="dropdown-content">
							    	<a href="#">내 정보</a>
							    	<a href="/logout">로그아웃</a>
							    	<a href="/user/study">내 스터디</a>
							  	</div>
						  	</div>
						<% } %>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="text-center">
					<div id='top-menus' class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li class='top-menu'><a href="/study/main"><strong>Study</strong></a>
							</li>
							<li class='top-menu'><a href="/notice/main"><strong>Notice</strong></a></li>
							<li class='top-menu'><a href="/user/study"><strong>My Study</strong></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>

</header>

