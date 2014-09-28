<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Title Type</title>
</head>
<body>
	<h3>New Title Type</h3>
	
	<s:url var="urlTiType" namespace="/admin" action="saveNewTitleType" includeContext="false"/>
	
	<s:form id="newTitleTypeForm" method="post" action="%{urlTiType}">
		<div class="greybackground">
			<s:label for="titleName" value="Name: "/>
			<s:textfield id="titleName" name="titleName" />
			<table>
				<thead>
					<th>Title Name</th>
				</thead>
				<tbody id="tbodyTitleType">
					<%@include file="iterTitleTypes.jsp" %>
				</tbody>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewTitleType" targets="tbodyTitleType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>