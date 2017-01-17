<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<section role="main" id="content" class="content left">
	<div class="xe-widget-wrapper">
                    <div class="contact-form bottom ">
                    	<div class= "container">
                    	<div style ="padding-right:10%, padding-left:10%" >
	                    	  <h2 class="text-center">회원 정보를 입력하세요</h2>
		                       <form class="form-horizontal" id ="memberEnroll" name ="memberEnroll">
								  <div class="form-group">
								    <label class="col-sm-4 control-label">google Mail</label>
								    <div class="col-sm-6">
								       <input type="googleID" class="form-control" id="inputGoogleID"   readonly="readonly" value="${user.mail}">
								   
								    </input>
								    
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="col-sm-4 control-label">닉네임</label>
								    <div class="col-sm-6">
								       <input type="nickName" class="form-control" id="inputNickName" readonly="readonly" value="${user.name}"  >
								    </div>
								  </div>
								
								  <div class="form-group">
								    <label class="col-sm-4 control-label">성별</label>
								    	 <label class="radio-inline" id ="gender" >
								     <c:choose>
								      <c:when test="${user.gender=='M'}">
								  	     <div class="col-sm-6">								  
									     	<input type="radio"  name="inlineRadioOptions" id="genderM"  value="M" disabled="disabled" checked="checked" > 남
									     </div>
									     <div class="col-sm-6">
			 					            <input type="radio"  name="inlineRadioOptions" id="genderF"  value="F" disabled="disabled" > 여
			 					         </div>
		 					         </c:when>
		 					         <c:when test="${user.gender=='F'}">		 					  
									 <div class="col-sm-6">								  
									     <input type="radio"  name="inlineRadioOptions" id="genderM"  value="M" disabled="disabled"  > 남
									 </div>
									 <div class="col-sm-6">
			 					         <input type="radio"  name="inlineRadioOptions" id="genderF"  value="F" disabled="disabled"  checked="checked"> 여
			 					     </div>
			 					     </c:when>
			 					     <c:otherwise>
			 					     <div class="col-sm-6">								  
									     <input type="radio"  name="inlineRadioOptions" id="genderM"  value="M" disabled="disabled"  > 남
									 </div>
									 <div class="col-sm-6">
			 					         <input type="radio"  name="inlineRadioOptions" id="genderF"  value="F"disabled="disabled"  > 여
			 					     </div>
			 					     </c:otherwise>
		 						</c:choose>
		 					         

								         
								    </label>   
								    </div>
		
								  <div class="form-group">
								    <label class="col-sm-4 control-label">사는 곳</label>
								    <div class="col-sm-3">
								       <select name="state" class="form-control" id="state"  disabled ="disabled" value="${user.city_id.name}">
											<c:forEach var="state" items="${stateList}">
												<option value="${state.id}">${state.name}</option>
											</c:forEach>
										</select>
								    </div>
								    <div class="col-sm-3">
								       <select name="city" class="form-control" id="city" disabled ="disabled" value="${user.city_id.name}">
											<c:forEach var="city" items="${cityList}">
												<option value="${city.code}">${city.name}</option>
											</c:forEach>
		
										</select>
								    </div>
								  </div>
								
								  
								  <div class="form-group">
								   <label class="col-sm-4 control-label">생일</label>
								     <div class="col-sm-6">
								  <input type="date" class="form-control" id="birthday" readonly="readonly" value="${userBirthdate}" >
								  </div>
								  </div>
								  <div class="form-group">
								    <label  class="col-sm-4 control-label">소개문장</label>
								    <div class="col-sm-6">
								      <textarea class="form-control" rows="3" id="myIntro" readonly="readonly" >${user.intro}</textarea>
								    </div>
								  </div>
								  <div class="col-sm-2 col-sm-offset-8" id ="updateDiv">
		                                <input type="button" id="updateBtn" class="btn btn-submit" value="수정하기" >
		                            </div>
		                          <div class="col-sm-2 col-sm-offset-8" id ="saveDiv"  style="display: none;">
		                                <input type="button"  id="saveBtn" class="btn btn-submit"" value="저장하기" >
		                           </div>
								</form>
							</div>
						</div>
                    </div>
                </div>

		</section>
</body>

<script>

$("#document").ready(function(){
	
});

$("#updateBtn").on('click',function(){
	$("#inputNickName").removeAttr('readonly');
	$("#genderM").removeAttr('disabled');
	$("#genderF").removeAttr('disabled');
	$("#state").removeAttr('disabled');
	$("#city").removeAttr('disabled');
	$("#birthday").removeAttr('readonly');
	$("#myIntro").removeAttr('readonly');
	
	alert("updateBtn1");
	$("#updateDiv").hide();
	alert("updateBtn2");
	$("#saveDiv").show();
	alert("updateBtn3");

});


	
	
	

	$("#saveBtn").on('click',function(){	
	alert($("#birthday").val());
		var params={
				
				"name" : $("#inputNickName").val(),
				"gender" : $("#genderRadio option:checked").val(),
			
				"city_id" : $("#cityList option:selected").val(),

				"intro" : $("#introduce").val()
		}
		$.ajax({
			type:"POST",
			url : "/user/update",
			data: params,
	
		     success: function (args) {
	             alert("success");
	             window.location.href = "/mypageMyIfo";
	         },
	         error:function(request,status,error){
	        	    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        	   }
	
		});
	});


</script>