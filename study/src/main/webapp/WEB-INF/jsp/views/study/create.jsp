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
    <div class="page-header">
        <h2 align="center">스터디를 만들어 주세요</h2>
    </div>
    <div class="page">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="study-title" class="col-md-3 col-sm-12 control-label">스터디 이름</label>

                <div id="study-title" class="col-md-4 col-sm-12">
                    <input id="title" name="title" type="text" class="form-control"
                           required="required" placeholder="Title">
                </div>
                <div class="col-md-5"></div>
            </div>
            <div class="form-group">
                <label for="study-subject" class="col-md-3 col-sm-12 control-label">스터디 주제</label>

                <div id="study-subject" class="col-md-2 col-sm-12">
                    <select name="subject" id="subject" class="col-md-12 col-sm-12 form-control">
                        <c:forEach var="subject" items="${subjectList}">
                            <option value="${subject.id}">${subject.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-7"></div>
            </div>
            <div class="form-group">
                <label for="study-city" class="col-md-3 col-sm-12 control-label">모임지역</label>

                <div id="study-city">
                    <div class="col-md-2 col-sm-6">
                        <select name="state" id="state" class="col-md-12 col-sm-12 form-control">
                            <option value="null" label="state" selected="true">시/도</option>
                            <c:forEach var="state" items="${stateList}">
                                <option value="${state.id}">${state.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-6">
                        <select name="city" id="city" class="col-md-12 col-sm-12 form-control">
                            <option value="null" label="city" selected="true">구/군/구</option>
                            <c:forEach var="city" items="${cityList}">
                                <option value="${city.code}" label="${city.stateId}"
                                        hidden="true">${city.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-5"></div>
            </div>
            <div class="form-group">
                <label for="study-intro" class="col-md-3 col-sm-12 control-label">스터디 소개</label>

                <div id="study-intro" class="col-md-6 col-sm-12">
                    <textarea id="intro" name="intro" required="required" class="form-control"
                              rows="8" placeholder="Your text here"></textarea>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="form-group">
                <label for="study-limit" class="col-md-3 col-sm-12 control-label">모집인원</label>

                <div id="study-limit">
                    <div class="col-md-2 col-sm-8">
                        <input id="limit" name="limit" type=number class="form-control" min="1"
                               max="30"
                               required="required" placeholder="Limit">
                    </div>
                    <div class="col-md-1 col-sm-4">
                        <h3>명</h3>
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="col-md-6"></div>
            </div>
            <div class="form-group">
                <div class="col-md-3"></div>
                <div class="col-md-6 col-sm-12">
                    <input type="submit" name="submit" class="btn btn-submit"
                           id="study-create-submit" value="submit">
                </div>
                <div class="col-md-3"></div>
            </div>
        </form>
    </div>
</div>
</body>

<script>
    $('#state').on('change', function () {
        $('#city option').each(function () {
            $(this).attr('hidden', false);
            $(this).attr('selected', false);

            if ($(this).context.label != $('#state option:selected').val()) {
                $(this).attr('hidden', true);
            }

            if ($(this).context.label == "city") {
                $(this).attr('selected', true);
                $(this).attr('hidden', false);
            }
        });
    });
    $("#study-create-submit").on('click', function () {
        var params = {
            "subjectId": $('#subject option:selected').val(),
            "title": $("#title").val(),
            "cityCode": $('#city option:selected').val(),
            "intro": $("#intro").val(),
            "memberLimit": $("#limit").val()
        }
        $.ajax({
            type: "POST",
            url: "/study",
            data: JSON.stringify(params),
            dataType: "html",
            contentType: "application/json; charset=UTF-8",
            success: function (args) {
                alert("success");
                window.location.href = "/studyMain";
            },
            error: function (e) {
                alert("error");
            }
        });
    });
</script>
