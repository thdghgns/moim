<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<div class="container" style="margin-top: 50px;">
		<div style="padding: 10px; float: left;">
			<h3 class="page-header">
				<strong>모임 지역</strong>
			</h3>
		</div>
		<div class="btn-group" style="padding: 10px; float: left;">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
			시/도 <span class="caret"></span>
		</a>
			<ul class="dropdown-menu" role="menu">
				<li>IT</li>
				<li>English</li>
				<li>Chinese</li>
			</ul>
		</div>

		<div class="dropdown" style="padding: 10px; float: left;">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				구/군/동 <span class="caret"></span>
			</a>
			<ul class="dropdown-menu" role="menu">
				<li>IT</li>
				<li>English</li>
				<li>Chinese</li>
			</ul>
		</div>

		<div style="padding: 10px; float: left;">
			<h3 class="page-header">
				<strong>주제</strong>
			</h3>
		</div>
		<div class="dropdown" style="padding: 10px; float: left;">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				주제 <span class="caret"></span>
			</a>
			<ul class="sub-menu" role="menu">
				<li>IT</a></li>
				<li>English</a></li>
				<li>Chinese</a></li>
			</ul>
		</div>
		<button type="submit" id="studySearch" class="btn btn-warning"
			style="padding: 10px;">찾기</button>
	</div>
	<div class="container">

		<button type="button" class="btn btn-warning btn-block" onclick="createStudy();">스터디
			만들기</button>
		<div class="w_list w_normal"
			style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
			<table class="table" style="font-size: 14">
				<thead>
					<tr>
						<th>순 번</th>
						<th>제 목</th>
						<th>소 개</th>
						<th>날 짜</th>
					</tr>
				</thead>
				<tbody>
					<!-- <c:forEach var="study" items="${studyList}" begin="0" varStatus="status"> -->
					<tr>
						<th scope="row">${title}</th>
						<td style="cursor: pointer; width: 290px"
							onclick="javascript:clickTitleEvent(this)">te</td>

					</tr>
					<c:forEach var="studyList" items="${studyList}" varStatus="status">
						<tr>
							<th scope="row">${study.id}</th>
							<td align="" class="" onclick="javascript:clickTitleEvent(this)">${study.title}</td>
							<td align="" class="" onclick="javascript:clickTitleEvent(this)">${study.intro}</td>
							<td align="" class="" onclick="javascript:clickTitleEvent(this)">${study.input_date}</td>
						</tr>
					</c:forEach>

					<!-- </c:forEach>		 -->
				</tbody>
			</table>
		</div>
	</div>
</body>

<script>
	function createStudy() {
		window.location.href = "/study/create-form";
	}
</script>