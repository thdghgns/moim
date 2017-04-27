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
					<span id='notice-detail-id' style="display: none;">${article.id}</span>
					<div id="notice-detail" class="col-md-12">
						<div class="">
							<div class="media-body">
								<blockquote>
									<h2>
										<b>제목 : <span id='notice-detail-title'>${article.title}</span></b>
									</h2>
									<h5 class='pull-right'>
										<b>작성자 : <span id='notice-detail-user'>${article.inputUser}</span></b>
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <b>작성날짜 :
											${article.inputDate}</b> 
									</h5>
								</blockquote>
							</div>
							<textarea name="message" id="notice-detail-content"
								class="form-control" rows="8" readonly="readonly">${article.content}</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>