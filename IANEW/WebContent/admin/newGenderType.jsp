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
	
	<s:url var="urlDisType" namespace="/admin" action="saveNewGenderType" includeContext="false"/>
	
	<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}">
		<div>
			<s:label for="genderName" value="Name: "/>
			<s:textfield id="genderName" name="genderName" />
			<s:label for="genderCode" value="Code" />
			<s:textarea id="genderCode" name ="genderCode" />
			<table>
				<tr>
					<th>Gender Name</th>
					<th>Gender Code</th>
				</tr>
				<s:iterator value="genderSelectList" status="stat">
				<tr>
					<td><s:property value="genderName"></s:property></td>
					<td><s:property value="genderDescription"></s:property></td>
				</tr>
				</s:iterator>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="save" targets="genderTypeSelect" cssClass="two columns alpha" value="Save" onclick=""/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>