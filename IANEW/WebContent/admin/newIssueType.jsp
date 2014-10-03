<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Issue Type</title>
</head>
<body>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Issue Type</h3>
	
	<s:url var="urlIssueType" namespace="/admin" action="saveNewIssueType" includeContext="false"/>
	<s:url var="urlUpdateIssueType" namespace="/admin" action="updateIssueType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="issueType" class="toggled hideable">
			<s:form id="newIssueTypeForm" method="post" action="%{urlIssueType}">
				<s:label for="issueName" value="Name: "/>
				<s:textfield id="issueName" name="issueName" />
				<s:label for="issueDescription" value="Description" />
				<s:textarea id="issueDescription" name ="issueDescription" cols="70" rows="1"/>
				<sj:submit id="saveNewIssue" targets="tbodyIssueType" cssClass="two columns alpha" value="Save"/>
			</s:form>
			<s:form id="editIssueTypeForm" method="post" action="%{urlUpdateIssueType}">
				<table>
					<thead>
						<tr>
							<th>Issue Name</th>
							<th>Issue Description</th>
						</tr>
					</thead>
					<tbody id="tbodyIssueType">
						<%@include file="iterIssueTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyIssueType" value="Update changes" id="btnEditIssue" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>