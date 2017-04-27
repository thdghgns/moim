<%--
  Created by IntelliJ IDEA.
  User: thdghgns
  Date: 2017. 3. 29.
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="import_contents">
	<div class="col-md-12 col-sm-12">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="row">

					<div class="notice-div-table">
						<div class="notice-div-table-body">
							<div class="notice-div-table-row">
								<div class="notice-div-table-cell orderCell">순번</div>
								<div class="notice-div-table-cell subjectCell">제목</div>
								<div class="notice-div-table-cell dateCell">날짜</div>
								<div class="notice-div-table-cell writerCell">작성자</div>
							</div>
							<c:forEach var="article" items="${studyArticles}">
								<div class="notice-div-table-row">
									<div class="notice-div-table-cell orderCell">${article.id}</div>
									<div class="notice-div-table-cell subjectCell">
										<a href="/study/article?articleId=${article.id}">${article.title}</a>
									</div>
									<div class="notice-div-table-cell dateCell">${article.inputDate}</div>
									<div class="notice-div-table-cell writerCell">${article.inputUser}</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="pull-right">
						<ul class="nav navbar-nav post-nav">
							<li><a href="/study/article/create-form?studyId=${study.id}"><i class="fa fa-tag"></i>write</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>