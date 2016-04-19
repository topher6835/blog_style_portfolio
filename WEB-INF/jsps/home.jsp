<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Name</title>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">

</head>

<body>
	<div id="pagetop">
		<div id="header">

			<div id="tophead"></div>
			<p id="headname">User Name</p>
			<sec:authorize access="isAuthenticated()">
				<p id="headlogout">
					<a href="<c:url value='/j_spring_security_logout'/>">Log out</a>
				</p>
			</sec:authorize>
			<p id="headcontact"><a href="${pageContext.request.contextPath}/contact">Contact</a></p>
			
			<div id="bottomhead"></div>
		</div>
		<div id="content">
			<div id="menubox">
			
				<a href="${pageContext.request.contextPath}/about">
				<div id="button1">
					<div id="item1"></div>
				</div>
				</a>
				<a href="${pageContext.request.contextPath}/resume">
				<div id="button2">
					<div id="item2"></div>
				</div>
				</a>
				<a href="${pageContext.request.contextPath}/photos">
				<div id="button3">
					<div id="item3"></div>
				</div>
				</a>

				<a href="${pageContext.request.contextPath}/about">
				<div id="capt1">
					<p>About</p>
					<div id="underline">
					</div>
				</div>
				</a>				
				<a href="${pageContext.request.contextPath}/resume">
				<div id="capt2">
					<p>Resume</p>
					<div id="underline">
					</div>
				</div>
				</a>
				<a href="${pageContext.request.contextPath}/photos">
				<div id="capt3">
					<p>Photos</p>
					<div id="underline">
					</div>
				</div>
				</a>

			</div>
		</div>
	</div>
	<div id="pagebottom">
		
		<div id="newsTable">
		
		<table class="news">
		<h2 id="latestNews">Latest News</h2>
		
		<sec:authorize access="isAuthenticated()"><p><a href="${pageContext.request.contextPath}/createlog">Create Entry</a></p></sec:authorize>
			<c:forEach var="log" varStatus="selectLog" items="${logs}">

				<tr>
					 <sec:authorize access="isAuthenticated()"><td id="editLogLink"><a href="${pageContext.request.contextPath}/edit?id=${log.id}">Edit</a></td></sec:authorize>
					
					<td id="dateLog">${log.date}</td>
					<td id="logText">${log.text}<c:if test="${log.linkUrl != null}"><br /><br /><c:url value="${log.linkUrl}" var="link" /><a href="${link}">${link}</a></c:if></td>
					
				</tr>

			</c:forEach>
			
		</table>
		
		</div>
	</div>

</html>