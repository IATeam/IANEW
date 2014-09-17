<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Accommodation Type</title>
</head>
<body>
	<h3>New Accommodation Type</h3>
	
	<s:url var="urlDisType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	
	<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}">
		<div>
			<s:label for="accommodationName" value="Name: "/>
			<s:textfield id="accommodationName" name="accommodationName" />
			<s:label for="accommodationDescription" value="Description" />
			<s:textarea id="accommodationDescription" name ="accommodationDescription" />
			<table>
				<tr>
					<th>Accommodation Name</th>
					<th>Accommodation Description</th>
				</tr>
				<s:iterator value="accommodationSelectList" status="stat">
				<tr>
					<td><s:property value="accommodationName"></s:property></td>
					<td><s:property value="accommodationDescription"></s:property></td>
				</tr>
				</s:iterator>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="save" targets="accommodationTypeSelect" cssClass="two columns alpha" value="Save" onclick=""/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>