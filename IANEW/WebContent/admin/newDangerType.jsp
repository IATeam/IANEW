<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Danger Type</title>
</head>
<body>
	<h3>New Danger Type</h3>
	
	<s:url var="urlDisType" namespace="/admin" action="saveNewDangerType" includeContext="false"/>
	
	<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}">
		<div>
			<s:label for="dangerName" value="Name: "/>
			<s:textfield id="dangerName" name="dangerName" />
			<s:label for="dangerDescription" value="Description" />
			<s:textarea id="dangerDescription" name ="DangerDescription" />
			<table>
				<tr>
					<th>Danger Name</th>
					<th>Danger Description</th>
				</tr>
				<s:iterator value="dangerSelectList" status="stat">
				<tr>
					<td><s:property value="dangerName"></s:property></td>
					<td><s:property value="dangerDescription"></s:property></td>
				</tr>
				</s:iterator>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="save" targets="dangerTypeSelect" cssClass="two columns alpha" value="Save" onclick=""/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>