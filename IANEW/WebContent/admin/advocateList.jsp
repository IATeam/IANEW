<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advocate List</title>
</head>
<body>
	<h3>Advocate List</h3>
		<div class="greybackground">
			<table>
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
				</thead>
				<tbody id="tbodyAdvocate">
					<%@include file="iterAdvocateList.jsp" %>
				</tbody>
			</table>
		</div>
</body>
</html>