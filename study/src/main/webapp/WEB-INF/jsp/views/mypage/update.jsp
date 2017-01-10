<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<body>
<section role="main" id="content" class="content left">
	<div class="xe-widget-wrapper">
                    <div class="contact-form bottom ">
                    	<div class= "container">
                    	<div style ="padding-right:10%, padding-left:10%" >
	                    	  <h2 class="text-center">회원 정보를 입력하세요</h2>
		                       <form class="form-horizontal" id ="memberEnroll" name ="memberEnroll" method="get" action="/membership">
								  <div class="form-group">
								    <label class="col-sm-4 control-label">google ID</label>
								    <div class="col-sm-6">
								       <input type="googleID" class="form-control" id="inputGoogleID" >
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="col-sm-4 control-label">닉네임</label>
								    <div class="col-sm-6">
								       <input type="nickName" class="form-control" id="inputNickName" >
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="col-sm-4 control-label">성별</label>

								    	 <label class="radio-inline" id ="sex">
								     <div class="col-sm-6">
								     	<input type="radio"  name="inlineRadioOptions" id="inlineRadio1" value="male"> 남
								     </div>
								     <div class="col-sm-6">
		 					            <input type="radio"  name="inlineRadioOptions" id="inlineRadio1" value="female"> 여
		 					         </div>

								         
								    </label>   
								    </div>
		
								  <div class="form-group">
								    <label class="col-sm-4 control-label">사는 곳</label>
								    <div class="col-sm-3">
								       <select name="state" class="form-control" id="stateList" >
											<c:forEach var="state" items="${stateList}">
												<option value="${state.id}">${state.name}</option>
											</c:forEach>
										</select>
								    </div>
								    <div class="col-sm-3">
								       <select name="city" class="form-control" id="cityList">
											<c:forEach var="city" items="${cityList}">
												<option value="${city.id}">${city.name}</option>
											</c:forEach>
		
										</select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="col-sm-4 control-label">관심분야</label>
								    <div class="col-sm-6">
								      <select name="subject" class="form-control" id="subjectList" >
								      		<c:forEach var="subjectList" items="${subjectList}">
												<option value="${subject.id}">${subject.name}</option>
											</c:forEach>
								      </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label  class="col-sm-4 control-label">소개문장</label>
								    <div class="col-sm-6">
								      <textarea class="form-control" rows="3"></textarea>
								    </div>
								  </div>
								  <div class="col-sm-2 col-sm-offset-8">
		                                <input type="submit" name="submit" class="btn btn-submit" value="수정하기">
		                            </div>
								</form>
							</div>
						</div>
                    </div>
                </div>

		</section>
</body>
