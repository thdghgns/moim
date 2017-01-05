<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<body>

<section role="main" id="content" class="content left">
	<div class="xe-widget-wrapper">
                    <div class="contact-form bottom ">
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
						    <div class="col-sm-">
						    	 <label class="radio-inline" id ="sex">
						     <div class="col-sm-2">
						     	<input type="radio" class="col-sm-2" name="inlineRadioOptions" id="inlineRadio1" value="male"> 남
						     </div>
						     <div class="col-sm-2">
 					            <input type="radio" class="col-sm-2" name="inlineRadioOptions" id="inlineRadio1" value="female"> 여
 					         </div>
			               </div>
						         
						    </label>   
						    </div>

						  
						  

						  <div class="form-group">
						    <label class="col-sm-4 control-label">사는 곳</label>
						    <div class="col-sm-3">
						       <select type="state" class="form-control" id="inputState" >
						  		  <option>서울</option>
								  <option>대전</option>
								  <option>경기</option>
								</select>
						    </div>
						    <div class="col-sm-3">
						       <select type="city" class="form-control" id="inputCity">
						        	<option>잠실</option>
								  <option>송파</option>
								  <option>금천</option>

								</select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="inputPassword" class="col-sm-4 control-label">관심분야</label>
						    <div class="col-sm-6">
						      <select type="subject" class="form-control" id="inputSubject" >
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="inputPassword" class="col-sm-4 control-label">소개문장</label>
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

		</section>
</body>
