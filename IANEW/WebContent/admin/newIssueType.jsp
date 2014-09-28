<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Issue Type</title>
</head>
<body>
	<h3>New Issue Type</h3>
	
	<s:url var="urlIssueType" namespace="/admin" action="saveNewIssueType" includeContext="false"/>
	
	<s:form id="newIssueTypeForm" method="post" action="%{urlIssueType}">
		<div class="greybackground">
			<s:label for="issueName" value="Name: "/>
			<s:textfield id="issueName" name="issueName" />
			<s:label for="issueDescription" value="Description" />
			<s:textarea id="issueDescription" name ="issueDescription" />
			<table>
				<thead>
					<th>Issue Name</th>
					<th>Issue Description</th>
				</thead>
				<tbody id="tbodyIssueType">
					<%@include file="iterIssueTypes.jsp" %>
				</tbody>
			</table>
		</div>
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewIssue" targets="tbodyIssueType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>