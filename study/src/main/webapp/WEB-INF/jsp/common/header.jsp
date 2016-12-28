<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String userName = "";

	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	} ;
%>
<header id="header">
	<div class="container">
		<div class="navbar navbar-inverse" role="banner"
			style="width: 500px; height: 100px;">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="hello">
						<h1>
							<img src="../images/logo1.png" alt="Moim"> Moim
						</h1>
					</a>
					<div class="search">
						<a href="/login"><i class="fa fa-google-plus"></i></a>
						<%=userName%>  
					</div>
				</div>

			</div>
			<div class="container">
				<div class="text-center">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li class="active"
								style="padding: 0px 15px 0px 15px !important; font-size: 20">
								<a href="/homeMain"><strong>home</strong></a>
							</li>
							<li class="dropdown"
								style="padding: 0px 15px 0px 15px !important; font-size: 20"><a
								href="/studyMain"><strong>Study</strong></a>
								<hr />
								<ul role="menu" class="sub-menu">
									<li><a href="/study">IT</a></li>
									<li><a href="/study">English</a></li>
									<li><a href="/study">Chinese</a></li>
								</ul></li>
							<li class="dropdown"
								style="padding: 0px 15px 0px 15px !important; font-size: 20"><a
								href="/noticeMain"><span><strong>Notice</strong></span></a>
								<hr />
								<ul role="menu" class="sub-menu">
									<li><a href="/board1">Notice</a></li>
									<li><a href="/board2">Q&A</a></li>
									<li><a href="/board3">AD</a></li>
								</ul></li>
							<li class="dropdown"
								style="padding: 0px 15px 0px 15px !important; font-size: 20"><a
								href="/mypageMain"><span><strong>My Page</strong></span></a>
								<hr />
								<ul role="menu" class="sub-menu">
									<li><a href="/mystudy">My Study</a></li>
									<li><a href="/myinfo">My Info</a></li>
								</ul></li>

							<li class="dropdown"
								style="padding: 0px 15px 0px 15px !important; font-size: 20"><a
								onclick="javascript:clickTotalMenu(this)"><span><strong>TotalMenu</strong></span></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

