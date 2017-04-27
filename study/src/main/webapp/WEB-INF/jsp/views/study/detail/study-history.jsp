<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div id="import_contents">
		<section id="blog" class="padding-bottom">
			<div calss="container">
				<div class="row">
					<div class="timeline-blog overflow">
						<div class="timeline-date text-center">
							<a href="/study/history-add?studyId=${studyId}"
								class="btn btn-common uppercase"> 추가하기 </a>
						</div>
						<div class="timeline-divider overflow padding-bottom">
							<c:forEach var="studyHistory" items="${studyHistoryList}"
								varStatus="status">

								<c:if test="${status.index%2==0}">
									<p>${status.index}</p>
									<div
										class="col-sm-6 padding-right arrow-right wow fadeInLeft animated"
										data-wow-duration="500ms" data-wow-delay="300ms"
										style="visibility: visible; animation-duration: 1000ms; animation-delay: 300ms; animation-name: fadedInLeft;">
										<div class="single-blog timeline">
											<div class="single-blog-wrapper">
												<div class="post-thumb">
													<img alt src="/images/blog/timeline/1.jpg"
														class="img-responsive">
												</div>
											</div>
											<div class="post-content overflow">
												<h2 class="post-title bold">
													<a href="게시판 글">${studyHistory.title}</a>
												</h2>
												<span class="post-author">Posted by
													${studyHistory.inputUser} </span>
												<p>${studyHistory.content}</p>
												<div class="post-bottom overflow">
													<span class="post-date pull-left">${studyHistory.inputDate}</span>
												</div>
											</div>
										</div>
									</div>
								</c:if>

								<c:if test="${status.index%2!=0}">
									<p>${status.index}</p>
									<div
										class="col-sm-6 padding-left arrow-left wow fadeInLeft animated"
										data-wow-duration="500ms" data-wow-delay="300ms"
										style="visibility: visible; animation-duration: 1000ms; animation-delay: 300ms; animation-name: fadedInLeft;">
										<div class="single-blog timeline">
											<div class="single-blog-wrapper">
												<div class="post-thumb">
													<img alt src="/images/blog/timeline/1.jpg"
														class="img-responsive">
												</div>
											</div>
											<div class="post-content overflow">
												<h2 class="post-title bold">
													<a href="게시판 글">${studyHistory.title}</a>
												</h2>
												<span class="post-author">Posted by
													${studyHistory.inputUser}</span>
												<p>${studyHistory.content}</p>
												<div class="post-bottom overflow">
													<span class="post-date pull-left">${studyHistory.inputDate}</span>
												</div>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
