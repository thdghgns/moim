<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
	<style>
.pop {
	margin: 0 auto;
	margin-top: 30px;
	width: 400px;
	height: 200px;
	background-color: #f5f5f5;
}
</style>

	<section role="main" id="content" class="content left">
	<div class="xe-widget-wrapper">
		<div class="contact-form bottom ">
			<div class="container">
				<div style="padding-right: 10%, padding-left:10%">
					<h2 align="center">스터디에 가입해보세요</h2>

					<form action ="/study-member" method = "POST" class="form-horizontal">
					<div style =" display : none">
						<input  id="studyId" name="studyId" value="${study.id}"> 
					</div>
							<div class="form-group">
							<label for="study-title" class="col-md-4 control-label">스터디
								이름</label>

							<div id="study-title" class="col-md-4 col-sm-12">
								<text id="title" name="title" class="form-control">${study.title}
							</div>
							<div class="col-md-5"></div>
						</div>
						<div class="form-group">
							<label for="study-subject" class="col-md-4 control-label">스터디
								주제</label>

							<div id="study-subject" class="col-md-4 col-sm-12">
								<text id="subject" name="subject" class="form-control">${studySubject.name}
							</div>
							<div class="col-md-7"></div>
						</div>
						<div class="form-group">
							<label for="study-city" class="col-md-4  control-label">모임지역</label>

							<div id="study-city">
								<div class="col-md-2 ">
									<text id="city" name="city" class="form-control">
									${studyState.name } 
								</div>
								<div class="col-md-2 ">
									<text id="state" name="state" class="form-control">${studyCity.name}
								</div>
							</div>

						</div>
						<div class="form-group">
							<label for="study-intro" class="col-md-4 control-label">스터디
								소개</label>

							<div id="study-intro" class="col-md-4 ">
								<text id="intro" name="intro" required="required"
									class="form-control" rows="8">${study.intro}</text>
							</div>
							<div class="col-md-3"></div>
						</div>
						<div class="form-group">
							<label for="study-limit" class="col-md-4 control-label">현재인원/모집인원</label>

							<div id="study-limit">
								<div class="col-md-2 ">
									<text id="limit" name="limit" type=number class="form-control">
									${study.memberCount} / ${study.memberLimit} 
								</div>
								<label class="col-md-1 control-label"> 명 </label>
							</div>
							<div class="col-md-9"></div>
						</div>

						<div class="form-group">
							<div class="col-md-4"></div>
							<div class="col-md-3 ">
								<input type="button" name="classifier" class="btn btn-submit"
									id="study-enroll" value="가입하기">
							</div>
							<div class="col-md-3"></div>
						</div>
			</form>		
			<form action ="/study-member" method = "POST" >
				<div class="pop" id="element_to_pop_up" style="display: none;">
			
						<input type="hidden" id="studyId" name="studyId" value="${study.id}"> 
			

					<div class="container" style="width: 400px; height: 200px;">
						<a class="b-close"
							style="cursor: pointer; color: #3f9798; font-size: x-large">x</a>
						<h3>가입인사를 해주세요</h3>
						<br> <input type="text" id="contentInput" class="form-control">
						<input type="submit" class="btn btn-submit" id="comment-insert"
							value="등록하기"></input>

					</div>
				</div>
				
			</form>
			
	


				</div>

			</div>
		</div>
	</div>


	</section>
</body>


<script>
	$("#study-enroll").on('click', function(e) {
		
		var str =   "<%=session.getAttribute("userId")%>";
		if(str == null){
			alert("로그인하세요");
		};
		e.preventDefault();
		$('#element_to_pop_up').bPopup({

		});
	});
	$("#comment-insert").on('click', function(e) {
		

		var studyId = $('#studyId').val();
		var content = $('#contentInput').val();
		
		//alert($('#contentInput').val());
		
		window.document.location.href = '/studyMember/enroll?studyId=' +studyId+'&content=' +content ;

/* 
		var form= document.createElement("form");
		form.setAttribute("method","POST");
		form.setAttribute("action","/study-member")
		var param=document.createElement("input");
		param.setAttribute("type","hidden");
		param.setAttribute("name","studyId");
		param.setAttribute("value",studyId);
		
		form.appendChild(param);
		
		form.submit();
*/		
		
		
	});

</script>

