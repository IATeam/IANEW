<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Cultural Background Type</title>
</head>
<body>
	<h3>New Cultural Background Type</h3>
	
	<s:url var="urlCulType" namespace="/admin" action="saveNewculturalBackgroundType" includeContext="false"/>
	
	<s:form id="newCulturalBackgroundTypeForm" method="post" action="%{urlCulType}">
		<div class="greybackground">
			<s:label for="culturalBackgroundName" value="Name: "/>
			<s:textfield id="culturalBackgroundName" name="culturalBackgroundName" />
			<s:label for="culturalBackgroundDescription" value="Description" />
			<s:textarea id="culturalBackgroundDescription" name ="culturalBackgroundDescription" />
			<table>
				<thead>
					<th>Cultural Background Type Name</th>
					<th>Cultural Background Type Description</th>
				</thead>
				<tbody id="tbodyCulturalBackgroundType">
					<%@include file="iterCulturalBackgroundTypes.jsp" %>
				</tbody>
			</table>
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewCulturalBackgroundType" targets="tbodyCulturalBackgroundType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>