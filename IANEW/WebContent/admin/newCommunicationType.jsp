<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Communication Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Communication Type</h3>
	<s:url var="urlNewComType" namespace="/admin" action="saveNewCommunicationType" includeContext="false"/>
	<s:url var="urlUpdateComType" namespace="/admin" action="updateCommunicationTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="communicationType" class="toggled hideable">
			<s:form id="newCommunicationTypeForm" method="post" action="%{urlNewComType}" onsubmit="clearInput()" >
				<s:label for="communicationTypeName" value="Name: "/>
				<s:textfield id="communicationTypeName" name="communicationTypeName" />
				<sj:submit id="saveNewCommunicationType" targets="tbodyCommunicationType" cssClass="two columns alpha" value="Save" />
			</s:form>	
			<s:form id="editCommunicationTypeForm" method="post" action="%{urlUpdateComType}">		
				<table>
					<thead>
						<tr>
							<th>Communication Name</th>
						</tr>
					</thead>
					<tbody id="tbodyCommunicationType">
						<%@include file="iterCommunicationTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyCommunicationType" value="Update changes" id="btnEditCommunication" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>