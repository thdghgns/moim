<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

	<div class="container">
		<div class="search-notice pull-right">
			<input id="notice-search-text" type="text" class="search-form" autocomplete="off"
				placeholder="Search"> <i id="notice-search-form" class="fa fa-search"></i>
		</div>
		<div class="notice-div-table">
			<div class="notice-div-table-body">
				<div class="notice-div-table-row">
					<div class="notice-div-table-cell orderCell">순번</div>
					<div class="notice-div-table-cell subjectCell">제목</div>
					<div class="notice-div-table-cell dateCell">날짜</div>
					<div class="notice-div-table-cell writerCell">작성자</div>
					<div class="notice-div-table-cell hitsCell">조회수</div>
				</div>
				<c:forEach var="contents" items="${noticeList}">
					<div class="notice-div-table-row">
						<div class="notice-div-table-cell orderCell">${contents.id}</div>
						<div class="notice-div-table-cell subjectCell"><a href="/notice/detail?indexNum=${contents.id}">${contents.title}</a></div>
						<div class="notice-div-table-cell dateCell">${contents.inputDate}</div>
						<div class="notice-div-table-cell writerCell">${contents.inputUser}</div>
						<div class="notice-div-table-cell hitsCell">${contents.hit}</div>
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
				<li class="notice-page-num"><a href="/notice/main?pageNum=${i}&searchText=${searchText}">${i}</a></li>
			</c:forEach>
			<li><a href="#">right</a></li>
		</ul>
	</div>
</body>
<script>

$("#notice-search-form").on('click', function() {
	window.document.location.href = '/notice/main?searchText=' + $('#notice-search-text').val();
});
</script>