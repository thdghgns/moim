<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- index.jsp made -->
<body> 
	<div class="container">
		<section role="main" id="content" class="content left">
			<div class="xe-widget-wrapper">
				<div style="*zoom: 1; padding: 0px 10px 0px 0px !important;">
					<div class="c_widget ct_box"
						style="padding: 20px; border-bottom: 1px dotted #CCC; background-color: #FFF;">
						<h2 class="w_headline">
							<a href="/study">IT<span class="page_count num"></span></a>
						</h2>
						<div class="w_list w_normal"
							style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
							<table class="table" style="font-size: 14">
								<tbody>
									<tr>
										<c:forEach var "subject" items="${subjectList}">
											<c:forEach var="subject" items="${subjectList}">
												<div class="divTableRow">
													<div class="divTableCell orderCell">${study.id}</div>
													<div class="divTableCell cityCell" value="${study.cityId}">${study.cityId.stateId.name},
														<br /> ${study.cityId.name}
													</div>
													<div class="divTableCell subjectCell"
														value="${study.subjectId}">${study.subjectId.name}</div>
													<div class="divTableCell titleCell">${study.title}</div>
													<div class="divTableCell dateCell">${study.inputDate}</div>
													<div class="divTableCell writerCell">${study.inputUser}</div>
													<div class="divTableCell hitsCell">${study.hit}</div>
												</div>
											</c:forEach>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<div class="footer_wrap">
		<footer class="footer">
			<div class="bottom_menu">
				<ul>
					<li><a href="/notice/main">Notice</a><span>|</span></li>
				</ul>
			</div>
		</footer>
	</div>
</body>

<script type="text/javascript">
	function clickTitleEvent(title) {
		window.open('/study_info', '_self');

	}

	function clickUserEvent(user) {
		$('[data-submenu]').submenupicker();
	}
</script>