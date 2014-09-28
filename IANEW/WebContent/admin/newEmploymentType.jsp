<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employment Type</title>
</head>
<body>
	<h3>New Employment Type</h3>
	
	<s:url var="urlEmpType" namespace="/admin" action="saveNewEmploymentType" includeContext="false"/>
	
	<s:form id="newEmploymentTypeForm" method="post" action="%{urlEmpType}">
		<div class="greybackground">
			<s:label for="employmentName" value="Name: "/>
			<s:textfield id="employmentName" name="employmentName" />
			<s:label for="employmentDescription" value="Description" />
			<s:textarea id="employmentDescription" name ="employmentDescription" />
			<table>
				<thead>
					<th>Employment Name</th>
					<th>Employment Description</th>
				</thead>
				<tbody id="tbodyEmploymentType">
					<%@include file="iterEmploymentTypes.jsp" %>
				</tbody>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewEmployment" targets="tbodyEmploymentType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>