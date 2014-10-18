<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>

</head>
<body>
	<h3 class="sixteen columns" style="float:none;">Client List</h3>
		<s:url var="urlUpdateClientType" namespace="/admin" action="saveOrUpdateContact" includeContext="false"/>
		<div class="greybackground">
		<s:form id="editClientTypeForm" method="post" action="%{urlUpdateClientType}">
			<table>
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
				</thead>
				<tbody id="tbodyClient">
					<%@include file="iterClientList.jsp" %>
				</tbody>
			</table>
		</s:form>
		</div>
</body>
</html>