<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.12.3.min.js"></script>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit entry</title>
</head>

<body>

<script type="text/javascript">
<!--
function onDeleteClick(event) {
	
	var doDelete = confirm("Are you sure you want to delete?");
	
	if(doDelete == false) {
		event.preventDefault();
	}
}

function onReady() {
	$("#delete").click(onDeleteClick);
}
$(document).ready(onReady);
//-->
</script>
	
	<form:form method="post" action="${pageContext.request.contextPath}/editlogsubmit" commandName="log">
	<form:input type="hidden" name="id" path="id"/>
	
	<h2 id="editTitle">Edit entry</h2>
	
		<table id="editLogTable">
			<tr><td id="editDate">Date: </td><td id="editDateEntry"><form:input class="control" path="date" name="date" type="text"/></td></tr>
			<tr><td id="editEntry">Entry: </td><td id="editTextEntry"><form:textarea class="control" path="text" name="text" /></td></tr>
			<tr><td>URL: </td><td id="editUrlEntry"><form:textarea class="control" path="linkUrl" name="linkUrl" /></td></tr>
			<tr><td class="label"> </td><td><input class="control" value="Save Entry" type="submit"/>
				<input class="deleteEntry control" name="delete" id="delete" value="Delete Entry" type="submit"/></td>				
			</tr>			
		</table>
		
	</form:form>
	
</body>
</html>