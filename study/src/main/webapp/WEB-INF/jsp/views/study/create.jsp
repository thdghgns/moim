<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SONG_HOHOON
  Date: 2016-12-29
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="container">
    <div class="col-md-10">
        <div class="">
            <h2>스터디를 만들어 주세요</h2>

            <div class="form-group">
                <table id="study">
                    <tr>
                        <td>
                            <h3>스터디 이름</h3>
                        </td>
                        <td>
                            <input id="study-title" name="title" type="text" class="form-control"
                                   required="required" placeholder="Title">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>스터디 주제</h3>
                        </td>
                        <td>
                            <select name="subject" id="subject">
                                <c:forEach var="subject" items="${subjectList}">
                                    <option value="${subject.id}">${subject.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>모임지역</h3>
                        </td>
                        <td>
                            <select name="state" id="state">
                                <c:forEach var="state" items="${stateList}">
                                    <option value="${state.id}">${state.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="city" id="city">
                                <option value="null" label="default" selected="true">-- Select --</option>
                                <c:forEach var="city" items="${cityList}">
                                    <option value="${city.code}" label="${city.stateId}">${city.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>스터디 소개</h3>
                        </td>
                        <td>
                            <textarea id="study-intro" name="intro" required="required" class="form-control"
                                      rows="8" placeholder="Your text here"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>모집인원</h3>
                        </td>
                        <td>
                            <input id="study-member-limit" name="limit" type=number class="form-control" min="1" max="30"
                                   required="required" placeholder="Limit">명
                        </td>
                    </tr>
                </table>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-submit"
                       id="study-create-submit" value="Submit">
            </div>
        </div>
    </div>
</div>
</body>

<script>
    $('#state').on('change', function(){
        $('#city option').each(function(){
            $(this).attr('hidden',false);
            $(this).attr('selected',false);

            if ($(this).context.label == "default") {
                $(this).attr('selected',true);
            }

            if ($(this).context.label != $('#state option:selected').val()) {
                $(this).attr('hidden',true);
            }
        });
    });
    $("#study-create-submit").on('click', function() {
        var params = {
            "subjectId" : $('#subject option:selected').val(),
            "title" : $("#study-title").val(),
            "cityCode" : $('#city option:selected').val(),
            "intro" : $("#study-intro").val(),
            "memberLimit" : $("#study-member-limit").val()
        }
        $.ajax({
            type : "POST",
            url : "/study",
            data : JSON.stringify(params),
            dataType : "html",
            contentType : "application/json; charset=UTF-8",
            success : function(args) {
                alert("success");
                window.location.href = "/studyMain";
            },
            error : function(e) {
                alert("error");
            }
        });
    });
</script>
