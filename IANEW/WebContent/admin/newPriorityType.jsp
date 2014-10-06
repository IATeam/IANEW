<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Priority Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Priority Type</h3>
	<s:url var="urlNewPriorityType" namespace="/admin" action="saveNewPriorityType" includeContext="false"/>
	<s:url var="urlUpdatePriorityType" namespace="/admin" action="updatePriorityTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="PriorityType" class="toggled hideable">
			<s:form id="newPriorityTypeForm" method="post" action="%{urlNewPriorityType}" onsubmit="clearInput()" >
				<s:label for="priorityName" value="Name: "/>
				<s:textfield id="priorityName" name="priorityName" />
				<sj:submit id="saveNewPriorityType" targets="tbodyPriorityType" cssClass="two columns alpha" value="Save" />
			</s:form>	
			<s:form id="editPriorityTypeForm" method="post" action="%{urlUpdatePriorityType}">		
				<table>
					<thead>
						<tr>
							<th>Priority Name</th>
						</tr>
					</thead>
					<tbody id="tbodyPriorityType">
						<%@include file="iterPriorityTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyPriorityType" value="Update changes" id="btnEditPriority" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>