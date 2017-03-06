<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- index.jsp made by lim_yungyoo -->
<body>
	<div class="container">
		<section role="main" id="content" class="content left">
			<div class="xe-widget-wrapper">
				<div style="*zoom: 1; padding: 0px 10px 0px 0px !important;">
					<div class="c_widget ct_box"
						style="padding: 20px; border-bottom: 1px dotted #CCC; background-color: #FFF;">
						<c:forEach var="subject" items="${subjectList}">
							<h2 class="w_headline">
								<a href="/study">${subject.name}<span class="page_count num"></span></a>
							</h2>
							<c:forEach var="studyList" items="${studyMap}">
							<c:if test="${subject.id == studyList.key}">
							<c:set var="study" value="${studyList.value}"/>
							<c:forEach var="studyObject" items="${study}">
								<div class="w_list w_normal"
									style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
									<table class="table" style="font-size: 14">
										<tbody>
											<tr>
												<button class="btn btn-default" id ="studySelect" value ="${studyObject.id}" style="border: 0px " onclick="studyClick(this)">
													
														<div class="divTableCell titleCell">${studyObject.title}</div>
														<div class="divTableCell dateCell">${studyObject.inputDate}</div>
														<div class="divTableCell writerCell">${studyObject.inputUser}</div>
														<div class="divTableCell hitsCell">${studyObject.hit}</div>
													</button>
											
											</tr>
										</tbody>
									</table>
								</div>
								</c:forEach>
								</c:if>
							</c:forEach>
							<br>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

<script type="text/javascript">
	function clickTitleEvent(title) {
		window.open('/study_info', '_self');

	}

	function clickUserEvent(user) {
		$('[data-submenu]').submenupicker();
	}
	
	function studyClick(obj)
	{
		alert(obj.value);
		window.document.location.href ='/study/detail?studyId=' + obj.value;
	}
	
	
</script>