<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container">
		<span id='notice-detail-id' style="display: none;">${detailList.id}</span>
		<div id="notice-detail" class="col-md-12">
			<div class="">
				<div class="media-body">
					<blockquote>
						<h1>
							<b>제목 : <span id='notice-detail-title'>${detailList.title}</span></b>
						</h1>
						<h5 class='pull-right'>
							<b>작성자 : <span id='notice-detail-user'>${detailList.inputUser}</span></b>
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <b>작성날짜 :
								${detailList.inputDate}</b>
						</h5>
					</blockquote>
				</div>
				<textarea name="message" id="notice-detail-content"
					class="form-control" rows="8" readonly="readonly">${detailList.content}</textarea>
			</div>
		</div>
		<div class="pull-right">
			<ul class="nav navbar-nav post-nav">
				<li id='notice-detail-edit'><a href="#"><i
						class="fa fa-pencil-square-o"></i>Edit</a></li>
				<li id='notice-detail-delete'><a href="#"><i
						class="fa fa-times"></i>Delete</a></li>
				<li id='notice-detail-modify' style="display: none;"><a
					href="#"><i class="fa fa-pencil-square-o"></i>Modify</a></li>
				<li id='notice-detail-cancel' style="display: none;"><a
					href="#"><i class="fa fa-pencil-square-o"></i>Cancel</a></li>
			</ul>
		</div>
	</div>
</body>

<script>
	$(document).ready(function() {
		$("#notice-detail-edit").on('click', function() {
			$("#notice-detail-modify").show();
			$("#notice-detail-cancel").show();
			$("#notice-detail-edit").hide();
			$("#notice-detail-delete").hide();

			$("#notice-detail-content").removeAttr('readonly');
			$("#notice-detail-content").focus();
		});

		$("#notice-detail-cancel").on('click', function() {
			$("#notice-detail-modify").hide();
			$("#notice-detail-cancel").hide();
			$("#notice-detail-edit").show();
			$("#notice-detail-delete").show();

			$("#notice-detail-content").attr('readonly', 'readonly');
		});

		$("#notice-detail-modify").on('click', function() {
			var modifyConfirm = confirm("수정 하시겠습니까?");
			if (modifyConfirm) {
				var userName = "unknown";

				var params = {
					"id" : $("#notice-detail-id")[0].innerHTML,
					"title" : $("#notice-detail-title")[0].innerHTML,
					"content" : $("#notice-detail-content").val(),
					"userName" : $("span#notice-detail-user")[0].innerHTML
				}

				$.ajax({
					type : "POST",
					url : "/notice/edit",
					data : params,
					success : function(args) {
						alert("success");
						window.location.href = "/notice/main";
					},
					error : function(e) {
						alert("error");
					}
				});
			}
		});

		$("#notice-detail-delete").on('click', function() {
			var deleteConfirm = confirm("삭제 하시겠습니까?");
			if (deleteConfirm) {
				var params = {
					"id" : $("#notice-detail-id")[0].innerHTML
				}

				$.ajax({
					type : "POST",
					url : "/notice/delete",
					data : params,
					success : function(args) {
						alert("success");
						window.location.href = "/notice/main";
					},
					error : function(e) {
						alert("error");
					}
				});
			}
		});
	});
</script>