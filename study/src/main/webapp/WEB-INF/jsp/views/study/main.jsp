<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div class="container">
		<div style="margin: 6px;">
			<h3 style="float: left; margin-left: 10px; margin-top: 6px; margin-bottom: 0px;">
			모임	지역</h3>

			<select name="state" id="stateSelect" 
				style="float: left; padding: 10px; margin-left: 10px;">
				<option value="">-</option>
				<c:forEach var="state" items="${stateList}">
					<option value="${state.id}">${state.name}</option>
				</c:forEach>
			</select>
			<select name="city" id="citySelect"
				style="float: left; padding: 10px; margin-left: 10px;">
				<c:forEach var="city" items="${cityList}">
					<option value="${city.code}">${city.name}</option>
				</c:forEach>
			</select>

			<h3
				style="float: left; margin-left: 20px; margin-top: 6px; margin-bottom: 0px;">주제
			</h3>
			<select name="subject" id="subject"
				style="float: left; padding: 10px; margin-left: 10px;">
				<option value="">-</option>
				<c:forEach var="subject" items="${subjectList}">
					<option value="${subject.id}">${subject.name}</option>
				</c:forEach>
			</select>

			<button type="submit" id="studySearch" class="btn btn-warning"
				style="padding: 8px; margin-left: 10px;">찾기</button>
		</div>

		<button type="button" class="btn btn-warning btn-block"
			style="margin: 15px;" onclick="location.href='/study/create-form'">스터디 만들기</button>
		<div class="divTable">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell orderCell">순번</div>
					<div class="divTableCell orderCell">지역</div>
					<div class="divTableCell subjectCell">제목</div>
					<div class="divTableCell dateCell">날짜</div>
					<div class="divTableCell writerCell">작성자</div>
					<div class="divTableCell hitsCell">조회수</div>
				</div>
				<c:forEach var="study" items="${studyList}">
					<div class="divTableRow">
						<div class="divTableCell orderCell">${study.id}</div>
						<div class="divTableCell orderCell">${study.cityId}</div>
						<div class="divTableCell subjectCell">${study.title}</div>
						<div class="divTableCell dateCell">${study.inputDate}</div>
						<div class="divTableCell writerCell">${study.inputUser}</div>
						<div class="divTableCell hitsCell">${study.hit}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<select style="float: left; padding: 5px; margin: 5px"
			onchange="changeState()"> 검색 조건
			<option value="title">제목</option>
			<option value="title_content">제목+내용</option>
			<option value="writer">작성자</option>
		</select> <input type="fa-search" style="margin: 5px;" id="search_content">
		<input type="submit" id="search_List" value="검색">

		<div class="blog-pagination">
			<ul class="pagination">
				<li><a href="#">left</a></li>
				<c:forEach var="i" begin="1" end="${totalPage}" step="1">
					<li class="notice-page-num"><a
						href="/notice/main?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<li><a href="#">right</a></li>
			</ul>
		</div>
</body>
<script type="text/javascript">
	
	//주제 선택

	// 스터디 선택 조회

	// 스터디 검색 조회
	
</script>

