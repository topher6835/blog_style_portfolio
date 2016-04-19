<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">

<title>About</title>
</head>
<body>

	<div id="header">

		<div id="tophead"></div>
		<p id="headname"><a href="${pageContext.request.contextPath}/">Home</a></p>
		<sec:authorize access="isAuthenticated()">
			<p id="headlogout">
				<a href="<c:url value='/j_spring_security_logout'/>">Log out</a>
			</p>
		</sec:authorize>
		<div id="bottomhead"></div>
	</div>

	<div id="about">
		<h1 id="aboutTitle">About User</h1>
		
			<sec:authorize access="isAuthenticated()">
			<p id="editAboutLink">
				<a href="${pageContext.request.contextPath}/editabout">Edit</a>
			</p>
			</sec:authorize>
	
		<div id="aboutBlock">

			<table id="aboutTable">

				<tr>
					<td id="aboutText">${about.about}</td>
				</tr>

			</table>
		</div>
	</div>

</body>
</html>