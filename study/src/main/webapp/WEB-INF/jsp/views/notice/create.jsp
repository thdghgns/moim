<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<div class="col-md-10">
			<div class="">
				<h2>공지사항 쓰기</h2>
				<form id="main-contact-form" name="contact-form" method="post"
					action="sendemail.php">
					<div class="form-group">
						<input type="text" name="name" class="form-control"
							required="required" placeholder="Name">
					</div>
					<div class="form-group">
						<input type="email" name="email" class="form-control"
							required="required" placeholder="Email Id">
					</div>
					<div class="form-group">
						<textarea name="message" id="message" required="required"
							class="form-control" rows="8" placeholder="Your text here"></textarea>
					</div>
					<div class="form-group">
						<input type="submit" name="submit" class="btn btn-submit"
							value="Submit">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>