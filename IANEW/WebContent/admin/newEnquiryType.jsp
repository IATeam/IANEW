<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Enquiry Type</title>
</head>
<body>
	<h3>New Enquiry Type</h3>
	
	<s:url var="urlEnType" namespace="/admin" action="saveNewEnquiryType" includeContext="false"/>
	
	<s:form id="newEnquiryTypeForm" method="post" action="%{urlEnType}">
		<div class="greybackground">>
			<s:label for="enquiryTypeName" value="Name: "/>
			<s:textfield id="enquiryTypeName" name="enquiryTypeName" />
			<s:label for="enquiryTypeDescription" value="Description" />
			<s:textarea id="enquiryTypeDescription" name ="enquiryTypeDescription" />
			<table>
				<thead>
					<th>Enquiry Type Name</th>
					<th>Enquiry Type Description</th>
				</thead>
				<tbody id="tbodyEnquiryType">
					<%@include file="iterEnquiryTypes.jsp" %>
				</tbody>
			</table>
			
		</div>
		
		<input type="button" value="Cancel" id="btnCancel"/>
		<input type="button" value="edit" id="btnEdit"/>
		<sj:submit id="saveNewEnquiryType" targets="tbodyEnquiryType" cssClass="two columns alpha" value="Save"/>
	</s:form>
	<script>
	$("#btnCancel").click(function(){
		$('#leftPopUp').hide("slow");
	});
	</script>
</body>
</html>