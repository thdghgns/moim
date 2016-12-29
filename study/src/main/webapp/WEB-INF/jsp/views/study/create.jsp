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
                <input id="study-title" name="title" type="text" class="form-control"
                       required="required" placeholder="Title">
            </div>
            <%-- subject --%>
            <%-- state, city --%>
            <div class="form-group">
                    <textarea id="study-intro" name="intro" required="required" class="form-control"
                              rows="8" placeholder="Your text here"></textarea>
            </div>
            <%-- member - limit --%>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-submit"
                       id="notice-create-submit" value="Submit">
            </div>
        </div>
    </div>
</div>
</body>
