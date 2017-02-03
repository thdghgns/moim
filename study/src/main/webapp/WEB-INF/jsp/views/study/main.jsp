<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div class="container">
		<div style="margin: 6px;">
			<h3
				style="float: left; margin-left: 10px; margin-top: 6px; margin-bottom: 0px;">
				모임 지역</h3>

			<select name="state" id="stateSelect"
				style="float: left; padding: 10px; margin-left: 10px;">
				<option value="">-</option>
				<c:forEach var="state" items="${stateList}">
					<option value="${state.id}">${state.name}</option>
				</c:forEach>
			</select> <select name="city" id="citySelect"
				style="float: left; padding: 10px; margin-left: 10px;">
				<option value="">-</option>
				<c:forEach var="city" items="${cityList}">
					<option value="${city.code}" label="${city.stateId}"
						style="display: none">${city.name}</option>
				</c:forEach>
			</select>

			<h3
				style="float: left; margin-left: 20px; margin-top: 6px; margin-bottom: 0px;">주제
			</h3>
			<select name="subject" id="subjectSelect"
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
			style="margin: 15px;" onclick="location.href='/study/create-form'">스터디
			만들기</button>
		<div class="divTable">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell orderCell">순번</div>
					<div class="divTableCell cityCell">지역</div>
					<div class="divTableCell subjectCell">주제</div>
					<div class="divTableCell subjectCell">제목</div>
					<div class="divTableCell dateCell">날짜</div>
					<div class="divTableCell writerCell">작성자</div>
					<div class="divTableCell hitsCell">조회수</div>
				</div>
				<c:forEach var="study" items="${studyList.content}">
					<div class="divTableRow">
						<div class="divTableCell orderCell">${study.id}</div>
						<div class="divTableCell cityCell" value="${study.cityId}">${study.cityId.stateId.name},
							<br /> ${study.cityId.name}
						</div>
						<div class="divTableCell subjectCell" value="${study.subjectId}">${study.subjectId.name}</div>
						<div class="divTableCell titleCell">${study.title}</div>
						<div class="divTableCell dateCell">${study.inputDate}</div>
						<div class="divTableCell writerCell">${study.inputUser}</div>
						<div class="divTableCell hitsCell">${study.hit}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<select style="float: left; padding: 5px; margin: 5px" id="searchType">
			검색 조건
			<option value="title">제목</option>
			<option value="title_content">제목+내용</option>
			<option value="writer">작성자</option>
		</select> <input type="fa-search" style="margin: 5px;" id="search_content">
		<button type="submit" id="search_content_btn">검색</button>

		<div class="blog-pagination">
			<ul class="pagination">
				<li><a href="#">left</a></li>
				<c:forEach var="i" begin="1" end="${studyList.size}" step="1">

				</c:forEach>
				<li><a href="#">right</a></li>
			</ul>
		</div>
</body>
<script type="text/javascript">
	//주소 선택
	$(function() {
			
		$('#stateSelect').on('change', function() {
			var stateId = $('#stateSelect option:selected').val();
			var cityId = $(this).context.label;
			if (stateId == "") {
				$('#citySelect option:selected').val("-");
				$('#citySelect option').css("display", "none");
			} else {
				$('#citySelect option').each(function() {
					if (stateId == $(this).context.label) {
						$(this).css("display", "");
					} else {
						$(this).css("display", "none");
					}
				})
			}
		})

		// 스터디 선택 조회

		$('#studySearch').on('click', function() {
			var stateId = $('#stateSelect option:selected').val();
			var cityId = $('#citySelect option:selected').val();
			var subjectId = $('#subjectSelect option:selected').val();

			if (stateId == "" && cityId == "" && subjectId == "") {
				$('.divTableRow').css("display", "");
			} else if (cityId != "" && subjectId == "") {

			} else {

			}
		})

		// 스터디 검색 조회
		$('#search_content_btn').on('click', function() {
			var search = $('#search_content').val();
			var params = { "keyword" : search,
				     "searchType" : $('#searchType').val()}
			
			if ( search == "") {
				alert("검색어를 입력하세요")
			} 
			else {
				$.ajax({
					url : "/study/search",
					type : "POST",
					data : params,
					dataType: json,
					success:function(args){
						alert(args);
						var result = "";
						divTableRow.html('');
						
						$.each(args, function (id, study){
							result += '<div class="divTableCell orderCell">'+ study.id +'</div>'+
								'<div class="divTableCell cityCell">'+study.cityId.stateId.name+','+'<br />'+study.cityId.name+
							'</div>'+
							'<div class="divTableCell subjectCell" value="'+study.subjectId+'">'+study.subjectId.name+'</div>'+
							'<div class="divTableCell titleCell">'+study.title+'</div>'
							'<div class="divTableCell dateCell">'+study.inputDate+'</div>'
							'<div class="divTableCell writerCell">'+study.inputUser+'</div>'
							'<div class="divTableCell hitsCell">'+study.hit+'</div>'
						});
						
						divTableRow.html(result);
						
					},
					error:function(e){
						alert("error");
					}
				});
			}
		})
	});
</script>

