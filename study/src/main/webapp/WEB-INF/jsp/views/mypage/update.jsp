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
								      <c:when test="${user.gender=='male'}">
								  	     <div class="col-sm-6">								  
									     	<input type="radio"  name="inlineRadioOptions" id="genderM"  value="male" disabled="disabled" checked="checked" > 남
									     </div>
									     <div class="col-sm-6">
			 					            <input type="radio"  name="inlineRadioOptions" id="genderF"  value="female" disabled="disabled" > 여
			 					         </div>
		 					         </c:when>
		 					         <c:when test="${user.gender=='female'}">		 					  
									 <div class="col-sm-6">								  
									     <input type="radio"  name="inlineRadioOptions" id="genderM"  value="male" disabled="disabled"  > 남
									 </div>
									 <div class="col-sm-6">
			 					         <input type="radio"  name="inlineRadioOptions" id="genderF"  value="female" disabled="disabled"  checked="checked"> 여
			 					     </div>
			 					     </c:when>
			 					     <c:otherwise>
			 					     <div class="col-sm-6">								  
									     <input type="radio"  name="inlineRadioOptions" id="genderM"  value="male" disabled="disabled"  > 남
									 </div>
									 <div class="col-sm-6">
			 					         <input type="radio"  name="inlineRadioOptions" id="genderF"  value="female"disabled="disabled"  > 여
			 					     </div>
			 					     </c:otherwise>
		 						</c:choose>
		 					         

								         
								    </label>   
								    </div>
		
								  <div class="form-group">
								    <label class="col-sm-4 control-label">사는 곳</label>
								    <div class="col-sm-3" id="userStateDiv">
								    <input type="userState" class="form-control"  readonly="readonly" id ="userState" value="${userState.name}">
								    </div>
								    
								    <div class="col-sm-3"style="display: none;" id = "stateDiv">
								       <select name="state" class="form-control" id="stateList" >
											<c:forEach var="state" items="${stateList}">
												<option value="${state.id}">${state.name}</option>
											</c:forEach>
										</select>
								    </div>
								    <div class="col-sm-3" id="userCityDiv" >
								    <input type="userCity" class="form-control" readonly="readonly" id ="userCity" value="${userCity.name}">
								    </div>								    
								    
								    <div class="col-sm-3" style="display: none;"  id = "cityDiv">
								       <select name="city" class="form-control" id="cityList" >
								       <option value="null" label="city" selected="true">
											<c:forEach var="city" items="${cityList}">
												<option value="${city.code}"  label="${city.stateId}" hidden="true">${city.name}</option>
											</c:forEach>
		
										</select>
								    </div>
								  </div>
								
								  
								  <div class="form-group">
								   <label class="col-sm-4 control-label">생일</label>
								     <div class="col-sm-6">
								  <input type="date" ="yyyy-mm-dd" class="form-control" id="birthday" readonly="readonly" value="${userBirthdate}" >
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

	$("#stateList").removeAttr('hidden');
	$("#cityList").removeAttr('hidden');
	$("#birthday").removeAttr('readonly');
	$("#myIntro").removeAttr('readonly');
	$("#userStateDiv").hide();
	$("#stateDiv").show();
	$("#userCityDiv").hide();
	$("#cityDiv").show();
	

	$("#updateDiv").hide();
	$("#saveDiv").show();

	
	

});

$('#stateList').on('change', function () {
    $('#cityList option').each(function () {
        $(this).attr('hidden', false);
        $(this).attr('selected', false);

        if ($(this).context.label != $('#stateList option:selected').val()) {
            $(this).attr('hidden', true);
        }

        if ($(this).context.label == "city") {
            $(this).attr('selected', true);
            $(this).attr('hidden', false);
        }
    });
});

	$("#saveBtn").on('click',function(){	

		var params={
				"mail" : $("#inputGoogleID").val(),
				"name" : $("#inputNickName").val(),
				"gender" : $(":input:radio[name=inlineRadioOptions]:checked").val(),
				"cityId" : $("#cityList option:selected").val(),
				"birthday" :new Date( $("#birthday").val()),
				"intro" : $("#myIntro").val()
		}
		$.ajax({
			type:"POST",
			url : "/user/update",
			data: params,
	
		     success: function (args) {
	             alert("success");
	             window.location.href = "/user/search";
	         },
	         error:function(request,status,error){
	        	    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        	   }
	
		});
	});


</script>