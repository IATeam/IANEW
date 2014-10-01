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
	
	<s:url var="urlAccType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	
	<s:form id="newAccommodationTypeForm" method="post" action="%{urlAccType}" onsubmit="clearInput()" >
		<div class="greybackground">
			<s:label for="accommodationName" value="Name: "/>
			<s:textfield id="accommodationName" name="accommodationName" />
			<s:label for="accommodationDescription" value="Description" />
			<s:textarea id="accommodationDescription" name ="accommodationDescription" />
			<sj:submit id="saveNewAccommodationType" targets="tbodyAccommodationType" cssClass="two columns alpha" value="Save" />
			<table>
				<thead>
					<th>Accommodation Name</th>
					<th>Accommodation Description</th>
				</thead>
				<tbody id="tbodyAccommodationType">
					<%@include file="iterAccommodationTypes.jsp" %>
				</tbody>
			</table>
		</div>
		
		<input type="button" value="Update changes" id="btnEditAccommodation" class="hidden"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	function clearInput(){
		$('#accommodationName').val('');
		$('#accommodationDescription').val('');
	}
	</script>
</body>
</html>