<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body onload="onLoad()">
<style>
    .pop {
        margin: 0 auto;
        margin-top: 30px;
        width: 400px;
        height: 200px;
        background-color: #f5f5f5;
    }
</style>
<section id="page-breadcrumb">
    <div class="vertical-center sun">
        <div class="container">
            <div class="row">
                <div class="action">
                    <div class="col-sm-12">
                        <h1 class="title">스터디에 가입해보세요</h1>
                        <p>Join us</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section role="main" id="projects" class="padding-top">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-4">
                <div class="sidebar portfolio-sidebar">
                    <div class="sidebar-item categories">
                        <h3>Study Menus</h3>
                        <ul class="nav navbar-stacked">
                            <li id="study-leftmenu-detail"><a id="study-detail" href="#">스터디 소개<span class="pull-right"></span></a></li>
                            <li id="study-leftmenu-dashboard"><a id="study-dashboard" href="#">스터디 게시판<span class="pull-right"></span></a></li>
                            <li><a id="study-member" href="#">스터디 팀원<span class="pull-right"></span></a></li>
                            <li><a id="study-history" href="#">스터디 기록<span class="pull-right"></span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="contents" class="col-md-9 col-sm-8" >
                <c:choose>
                    <c:when test="${selectedMenu eq 'info'}">
                        <jsp:include page="detail/study-info.jsp" flush="true" />
                    </c:when>
                    <c:when test="${selectedMenu eq 'dashboard'}">
                        <jsp:include page="detail/study-dashboard.jsp" flush="true" />
                    </c:when>
                </c:choose>
            </div>
        </div>

    </div>
</section>
</body>


<script>



$("#document").ready(function(){
	
	var str =   <%=session.getAttribute("userId")%>;
	if(str == null){
		alert("로그인하세요");
		window.document.location.href ='/login'
	};
	var str ="${userClassifier}";
	if(str == "leader"){
		$("#study-enroll").hide();
		$("#study-quit").hide();
		$("#study-remove").show();
		
	}else if (str == "teamone"){
		$("#study-enroll").hide();
		$("#study-quit").show();
		$("#study-remove").hide();
		
	}
	else {		
		$("#study-enroll").show();
		$("#study-quit").hide();
		$("#study-remove").hide();		
	}
});






	$("#study-enroll").on('click', function(e) {
		

		e.preventDefault();
		$('#element_to_pop_up').bPopup({

		});
	});
	

	
	
	$("#comment-insert").on('click', function(e) {
		

		var studyId = $('#studyId').val();
		var content = $('#contentInput').val();
		var userClassifier= "${userClassifier}";
		
		//alert($('#contentInput').val());
		
		window.document.location.href = '/studyMember/enroll?studyId=' +studyId+'&content=' + content + '&userClassifier=' + userClassifier;

		
		
	});
	

	$("#study-quit").on('click', function(e) {
		
		var str =   "<%=session.getAttribute("userId")%>";
		if(str == null){
			alert("로그인하세요");
		};
		e.preventDefault();
		alert ("정말 탈퇴하시겠습니까?")
		var studyId = $('#studyId').val();
		var content = $('#contentInput').val();
		var userClassifier= "${userClassifier}";
		window.document.location.href = '/studyMember/enroll?studyId=' +studyId+'&content=' + content + '&userClassifier=' + userClassifier;

		
	});

   
    function onLoad() {
        var domain = window.location.protocol + "//" + window.location.host;

        var study_info_url = domain + "/study/detail?studyId=" + ${study.id};
        $("#study-detail").attr("href", study_info_url);

        var study_dashboard_url = domain + "/study/dashboard?studyId=" + ${study.id};
        $("#study-dashboard").attr("href", study_dashboard_url);

        switch ("${selectedMenu}") {
            case "info":
                $("#study-leftmenu-detail").attr("class", "active");
                break;
            case "dashboard":
                $("#study-leftmenu-dashboard").attr("class", "active");
                break;
        }
    }

</script>

