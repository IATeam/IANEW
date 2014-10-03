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
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Enquiry Type</h3>
	<s:url var="urlEnType" namespace="/admin" action="saveNewEnquiryType" includeContext="false"/>
	<s:url var="urlUpdateEnType" namespace="/admin" action="updateEnquiryType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="enquiryType" class="toggled hideable">
			<s:form id="newEnquiryTypeForm" method="post" action="%{urlEnType}">
				<s:label for="enquiryTypeName" value="Name: "/>
				<s:textfield id="enquiryTypeName" name="enquiryTypeName" />
				<s:label for="enquiryTypeDescription" value="Description" />
				<s:textarea id="enquiryTypeDescription" name ="enquiryTypeDescription" />
				<sj:submit id="saveNewEnquiryType" targets="tbodyEnquiryType" cssClass="two columns alpha" value="Save"/>
			</s:form>
			<s:form id="editEnquiryTypeForm" method="post" action="%{urlUpdateEnType}">
				<table>
					<thead>
						<tr>
							<th>Enquiry Type Name</th>
							<th>Enquiry Type Description</th>
						</tr>
					</thead>
					<tbody id="tbodyEnquiryType">
						<%@include file="iterEnquiryTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyEnquiryType" value="Update changes" id="btnEditEnquiry" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>