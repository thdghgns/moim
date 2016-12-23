<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contentPage = request.getParameter("CONTENTPAGE"); %>

<jsp:include page="common/include.jsp" flush="false" />
<jsp:include page="common/header.jsp" flush="false" />
<jsp:include page="<%=contentPage%>" flush="false"/>
<jsp:include page="common/footer.jsp" flush="false" />
