<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<div class="col-md-12">
			<div class="">
				<h2>공지사항 쓰기</h2>
				<div class="form-group">
					<input type="text" name="name" class="form-control"
						id="notice-create-title" required="required" placeholder="Title">
				</div>
				<div class="form-group">
					<textarea name="message" id="notice-create-content"
						required="required" class="form-control" rows="8"
						placeholder="Your text here"></textarea>
				</div>
				<div class="form-group">
					<input type="submit" name="submit" class="btn btn-submit"
						id="notice-create-submit" value="Submit">
				</div>

			</div>
		</div>
	</div>
</body>


<script>
	$("#notice-create-submit").on('click', function() {
		var params = {
			"title" : $("#notice-create-title").val(),
			"content" : $("#notice-create-content").val()
		}
		$.ajax({
			type : "POST",
			url : "/notice/create",
			data : params,
			success : function(args) {
				alert("success");
				window.location.href = "/notice/main";
			},
			error : function(e) {
				alert("error");
			}
		});
	});
</script>
