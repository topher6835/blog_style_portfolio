<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit about</title>

</head>

<body>

	<form:form method="post" action="${pageContext.request.contextPath}/editaboutsubmit" commandName="about">
	<form:input type="hidden" name="id" path="id"/>
	
	<h2 id="editAboutTitle">Edit about</h2>
	
	<table id="editAboutTable">
		<tr><td id="editAboutEntry"><form:textarea class="control" path="about" name="about" /></td></tr>
		<tr><td><input class="control" value="Save Entry" type="submit"/></td></tr>
	</table>
	
	</form:form>

</body>
</html>