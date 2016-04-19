<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit contact info</title>
</head>
<body>

	<form:form method="post" action="${pageContext.request.contextPath}/editcontactsubmit" commandName="contact">
		<form:input type="hidden" name="id" path="id" />

		<h2 id="editTitle">Edit contact info</h2>

		<table id="editContactTable">
			<tr><td>Email: </td><td id="editEmailEntry"><form:textarea class="control" path="email" name="email" type="text"/></td></tr>
			<tr><td>Phone: </td><td id="editPhoneEntry"><form:textarea class="control" path="phone" name="text" /></td></tr>
			<tr><td>Address: </td><td id="editAddressEntry"><form:textarea class="control" path="address" name="address" /></td></tr>
			<tr><td>Additional info: </td><td id="editAdditionalEntry"><form:textarea class="control" path="additional" name="additional"/></td></tr>
			<tr><td class="label"> </td><td><input class="control" value="Save Info" type="submit"/></td></tr>
		</table>
	</form:form>

</body>
</html>