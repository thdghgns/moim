<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div id="mypage-wrap">
		<div id="mypage-header">
			<div id="mypage-content">
				<div class="user-photo"></div>
				<div id="tab">
					<div id="user-name">${userName}</div>
					<div id="tab-box">
						<a class="tab selected" href="/user/made_study">개설한 스터디</a> 
						<a class="tab" href="/user/joined_study">가입한 스터디</a>
					</div>
				</div>

			</div>
		</div>
		<section id="mypage-studyList-section">
			<c:set var="myStudyList" value="${myStudyList}" />
			<c:choose>
				<c:when test="${empty myStudyList}">
					<span>아직 참여중인 스터디가 없네요</span>
					<br>
					<span>가입한 스터디를 여기서 관리하고 후기를 남길 수 있어요</span>
				</c:when>
				<c:otherwise>
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
							<c:forEach var="study" items="${myStudyList}">
								<div class="divTableRow">
									<div class="divTableCell orderCell">${study.id}</div>
									<div class="divTableCell cityCell" value="${study.city.code}">${study.city.stateId.name},
										<br /> ${study.city.name}
									</div>
									<div class="divTableCell subjectCell" value="${study.subject}">${study.subject.name}</div>
									<div class="divTableCell titleCell">
										<a href="/study/detail?studyId=${study.id}">${study.title}</a>
									</div>
									<div class="divTableCell dateCell">${study.inputDate}</div>
									<div class="divTableCell writerCell">${study.inputUser}</div>
									<div class="divTableCell hitsCell">${study.hit}</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
</body>