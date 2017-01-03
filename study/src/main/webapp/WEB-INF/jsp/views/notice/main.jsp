<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container">
		<div class="search-notice pull-right">
			<input type="text" class="search-form" autocomplete="off"
				placeholder="Search"> <i class="fa fa-search"></i>
		</div>
		<div class="divTable">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell orderCell">순번</div>
					<div class="divTableCell subjectCell">제목</div>
					<div class="divTableCell dateCell">날짜</div>
					<div class="divTableCell writerCell">작성자</div>
					<div class="divTableCell hitsCell">조회수</div>
				</div>
				<c:forEach var="contents" items="${noticeList}">
					<div class="divTableRow">
						<div class="divTableCell orderCell">${contents.id}</div>
						<div class="divTableCell subjectCell"><a href="/notice/detail?indexNum=${contents.id}">${contents.title}</a></div>
						<div class="divTableCell dateCell">${contents.inputDate}</div>
						<div class="divTableCell writerCell">${contents.inputUser}</div>
						<div class="divTableCell hitsCell">${contents.hit}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="pull-right">
			<ul class="nav navbar-nav post-nav">
				<li><a href="/notice/create"><i class="fa fa-tag"></i>Creative</a></li>
			</ul>
		</div>
	</div>
	<div class="blog-pagination">
		<ul class="pagination">
			<li><a href="#">left</a></li>
			<c:forEach var="i" begin="1" end="${totalPage}" step="1">
				<li class="notice-page-num"><a href="/notice/main?pageNum=${i}">${i}</a></li>
			</c:forEach>
			<li><a href="#">right</a></li>
		</ul>
	</div>
</body>
<!-- DivTable.com -->