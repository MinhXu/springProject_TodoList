<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Information Form</title>
</head>
<body>

<spring:url value="/save" var="saveURL"></spring:url>
<form:form modelAttribute="jobForm" method="POST" action="${saveURL }">
<form:hidden path="id"/>
<table>
	<tr>
		<td>Id</td>
		<td><form:input path="jobId"/></td>
	</tr>
	<tr>
		<td>Description</td>
		<td><form:input path="jobDescription"/></td>
	</tr>
	<tr>
		<td>Creation Date</td>
		<td><form:input path="jobCreateDate"/></td>
	</tr>
	<tr>
		<td>Status</td>
		<td><form:input path="jobStatus"/></td>
	</tr>
	<tr>
		<td>Rate</td>
		<td><form:input path="jobRate"/></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="button"></button>
	</tr>
</table>
</form:form>

</body>
</html>