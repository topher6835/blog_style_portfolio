<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Entry</title>
</head>
<body>

<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value='${now}' dateStyle='long' var='date' />

<h2 id="createTitle">Create a new entry</h2>

	<form:form method="post" action="${pageContext.request.contextPath}/createlogsubmit" commandName="log" id="createForm">
		<table class="createLogTable">
			<tr><td id="createDate">Date: </td><td id="createDateEntry"><form:input class="control" path="date" name="date" type="text" value="${date}"/></td></tr>
			<tr><td id="createText">Entry: </td><td id="createTextEntry"><form:textarea class="control" path="text" name="text" /></td></tr>
			<tr><td>URL: </td><td id="createUrlEntry"><form:textarea class="control" path="linkUrl" name="linkUrl" /></td></tr>
			<tr><td id="label"> </td><td id="createButton"><input class="control" name="Submit Entry" type="submit"/></td></tr>
		</table>
	</form:form>

</body>
</html>