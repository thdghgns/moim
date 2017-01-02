<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="container">
		<div class="col-md-12">
			<div class="">
				<div class="media-body"><blockquote><h2><b>TITLE : ${detailList.title}</b></h2></blockquote></div>
				<textarea name="message" id="notice-detail-content" class="form-control"
					rows="8" readonly="readonly" >${detailList.content}</textarea>

			</div>
		</div>
	</div>
</body>
