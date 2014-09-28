<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Gender Type</title>
</head>
<body>
	<h3>New Gender Type</h3>
	
	<s:url var="urlGenType" namespace="/admin" action="saveNewGenderType" includeContext="false"/>
	
	<s:form id="newGenderTypeForm" method="post" action="%{urlGenType}">
		<div class="greybackground">
			<s:label for="genderName" value="Name: "/>
			<s:textfield id="genderName" name="genderName" />
			<s:label for="genderCode" value="Code" />
			<s:textarea id="genderCode" name ="genderCode" />
			<table>
				<theadr>
					<th>Gender Name</th>
					<th>Gender Code</th>
				</thead>
				<tbody id="tbodyGenderType">
					<%@include file="iterGenderTypes.jsp" %>
				</tbody>
			</table>
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewGender" targets="tbodyGenderType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>