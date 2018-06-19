<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Job List Information</title>
</head>
<body>
	<h1>Job List</h1>
	<table width= "100%" border="1">
	<tr>
		<th>Job ID</th>
		<th>Job Description</th>
		<th>Job Creation Date</th>
		<th>Job Status</th>
		<th>Job Rate</th>
		<th colspan="2"> Action</th>
	</tr>
	<c:forEach items= "${listJob}" var="job">
		<tr>
			<td>${job.jobId }</td>
			<td>${job.jobDescription}"</td>
			<td>${job.jobCreateDate}</td>
			<td>${job.jobStatus}</td>
			<td>${job.jobRate}</td>
			<td>
				<spring:url value="/update/${job.jobId }" var="updateURL"/>
				<a href="${updateURL }">Update</a>
			</td>
			<td>
				<spring:url value="/delete/${job.jobId }" var="deleteURL"/>
				<a href="${deleteURL }">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>