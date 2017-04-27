<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div id="import_contents">
			<div class="page-header">
				<h2 align="center">모임을 추가하세요~</h2>
			</div>
			<div class="page">
				<form class="form-horizontal">

					<div class="form-group">
						<label for="studyHistory-title"
							class="col-md-3 col-sm-12 control-label">모임 이름</label>

						<div id="studyHistory-title" class="col-md-4 col-sm-12">
							<input id="title" name="title" type="text" class="form-control"
								required="required" placeholder="Title">
						</div>
						<div class="col-md-5"></div>
					</div>

					<div class="form-group">
						<label for="studyHistory-content"
							class="col-md-3 col-sm-12 control-label"></label>

						<div id="studyHistory-content" class="col-md-6 col-sm-12">
							<textarea id="content" name="content" required="required"
								class="form-control" rows="8" placeholder="Your text here"></textarea>
						</div>
						<div class="col-md-3"></div>
					</div>
					<div class="form-group">
						<label class="col-md-3 col-sm-12 control-label"></label>
						<form method="post" enctype="multipart/form-data"
							action="image-upload.jsp">
							<input class="col-md-5 col-sm-12" type="file" name="filename">
							<input type="submit" value="사진추가">
						</form>
					</div>
					<div class="form-group">
						<div class="col-md-3"></div>
						<div class="col-md-6 col-sm-12">
							<input type="submit" name="submit" class="btn btn-submit"
								id="history-create-submit" value="submit">
						</div>
						<div class="col-md-3"></div>
					</div>
				</form>
			</div>
	</div>
</body>
</html>
<script>
	$("#history-create-submit")
			.on(
					'click',
					function() {
						var params = {
							"studyId" : "${studyId}",
							"title" : $("#title").val(),
							"content" : $("#content").val()
						}
						$
								.ajax({
									type : "POST",
									url : "/study/save-studyHistory",
									data : JSON.stringify(params),
									dataType : "html",
									contentType : "application/json; charset=UTF-8",
									success : function(args) {
										alert("success");
										window.location.href = "/study/history?studyId=${studyId}";
									},
									error : function(request, status, error) {
										alert("code:" + request.status + "\n"
												+ "message:"
												+ request.responseText + "\n"
												+ "error:" + error);
										alert("studyId : " + params.studyId
												+ "\n");
									}
								});
					});
</script>
