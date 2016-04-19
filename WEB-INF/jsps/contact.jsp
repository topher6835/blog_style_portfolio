<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact info</title>
</head>

<body>

	<div id="header">

		<div id="tophead"></div>
		<p id="headname">
			<a href="${pageContext.request.contextPath}/">Home</a>
		</p>
		<sec:authorize access="isAuthenticated()">
			<p id="headlogout">
				<a href="<c:url value='/j_spring_security_logout'/>">Log out</a>
			</p>
		</sec:authorize>
		<div id="bottomhead"></div>
	</div>

	<div id="contact">
		<h1 id="contactTitle">Contact User</h1>

		<sec:authorize access="isAuthenticated()">
			<p id="editContactLink">
				<a href="${pageContext.request.contextPath}/editcontact">Edit</a>
			</p>
		</sec:authorize>

		<div id="contactBlock">

			<table id="contactTable">

				<tr>
					<td>Email: </td><td id="contactText">${contact.email}</td>
				</tr>
				<tr>
					<td>Phone: </td><td id="contactText">${contact.phone}</td>
				</tr>
				<tr>
					<td>Address: </td><td id="contactText">${contact.address}</td>
				</tr>
				<c:if test="${contact.additional != null}">
					<tr><td></td></tr>
					<tr><td></td></tr>
					<tr><td></td></tr>
					<tr>
						<td></td><td id="contactText">${contact.additional}</td>
					</tr>
				</c:if>

			</table>
		</div>
	</div>

</body>
</html>