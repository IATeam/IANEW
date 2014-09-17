<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
	<h3>New User</h3>
	
	<s:url var="urlDisType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	
	<s:form id="newDisabilityTypeForm" method="post" action="%{urlDisType}">
		<div>
			<s:label for="" value="Username: "/>
			<s:textfield id="" name="" />
			<s:label for="" value="Password:" />
			<s:password id="" name ="" />			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				<s:iterator value="contactsSelectList" status="stat">
				<tr>
					<td><s:property value="firstname"></s:property></td>
					<td><s:property value="lastname"></s:property></td>
				</tr>
				</s:iterator>
			</table>
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="save" targets="ContactsSelect" cssClass="two columns alpha" value="Save" onclick=""/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>