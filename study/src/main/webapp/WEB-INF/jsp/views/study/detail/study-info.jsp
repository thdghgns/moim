<%--
  Created by IntelliJ IDEA.
  User: thdghgns
  Date: 2017. 3. 28.
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="import_contents">
    <div class="col-md-12 col-sm-8">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 portfolio-item branded logos">
                <div class="portfolio-wrapper">
                    <div class="portfolio-single">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="study-title" class="col-md-4 control-label">스터디 이름</label>

                                <div id="study-title" class="col-md-4 col-sm-12">
                                    <text id="title" name="title" class="form-control">${study.title}</text>
                                </div>
                                <div class="col-md-5"></div>
                            </div>
                            <div class="form-group">
                                <label for="study-subject" class="col-md-4 control-label">스터디 주제</label>

                                <div id="study-subject" class="col-md-4 col-sm-12">
                                    <text id="subject" name="subject" class="form-control">${studySubject.name}</text>

                                </div>
                                <div class="col-md-7"></div>
                            </div>
                            <div class="form-group">
                                <label for="study-city" class="col-md-4  control-label">모임지역</label>

                                <div id="study-city">
                                    <div class="col-md-2 ">
                                        <text id="city" name="city" class="form-control"> ${studyState.name }</text>
                                    </div>
                                    <div class="col-md-2 ">
                                        <text id="state" name="state" class="form-control">${studyCity.name}</text>
                                    </div>
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="study-intro" class="col-md-4 control-label">스터디 소개</label>

                                <div id="study-intro" class="col-md-4 ">
                                    <text id="intro" name="intro" required="required" class="form-control"
                                          rows="8">${study.intro}
                                    </text>
                                </div>
                                <div class="col-md-3"></div>
                            </div>
                            <div class="form-group">
                                <label for="study-limit" class="col-md-4 control-label">현재인원/모집인원</label>

                                <div id="study-limit">
                                    <div class="col-md-2 ">
                                        <text id="limit" name="limit" type=number
                                              class="form-control"> ${study.memberCount} / ${study.memberLimit}
                                        </text>
                                    </div>
                                    <label class="col-md-1 control-label"> 명
                                    </label>
                                </div>
                                <div class="col-md-9"></div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4"></div>
                                <div class="col-md-3 ">
                                    <input type="button" name="submit" class="btn btn-submit"
                                           id="study-enroll" value="가입하기">
                                </div>
                                <div class="col-md-3"></div>
                            </div>
                        </form>
                        <div class="pop" id="element_to_pop_up" style="display: none;">

                            <div class="container" style="width:400px;height:200px; ">
                                <a class="b-close"
                                   style=" cursor: pointer; color: #3f9798; font-size:x-large">x</a>
                                <h3>가입인사를 해주세요 </h3>
                                <br>
                                <input type="text" id="content" class="form-control">
                                <input type="button" class="btn btn-submit" id="comment-insert" value="등록하기"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>