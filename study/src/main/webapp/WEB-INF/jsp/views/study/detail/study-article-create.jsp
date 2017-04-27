<%--
  Created by IntelliJ IDEA.
  User: thdghgns
  Date: 2017. 3. 29.
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="import_contents">
	<div class="col-md-12 col-sm-12">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="row">
					<div class="">
						<h2>게시글 작성</h2>
						<div class="form-group">
							<input type="text" name="name" class="form-control"
								id="article-create-title" required="required" placeholder="Title">
						</div>
						<div class="form-group">
							<textarea name="message" id="article-create-content"
								required="required" class="form-control" rows="8"
								placeholder="Your text here"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-submit"
								id="article-create-submit" value="Submit">
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$("#article-create-submit").on('click', function() {
		var params = {
			"title" : $("#article-create-title").val(),
			"content" : $("#article-create-content").val()
		}
		$.ajax({
			type : "POST",
			url : "/study/article?studyId=${study.id}",
			data: JSON.stringify(params),
			dataType: "html",
            contentType: "application/json; charset=UTF-8",
			success : function(args) {
				window.location.href = "/study/articles?studyId=${study.id}";
			},
			error : function(e) {
				if(JSON.parse(e.responseText).message == "NotNullModifyUser") {
					alert("로그인이 필요합니다.");
				} else {
					alert("error");
				}
			}
		});
	});
</script>