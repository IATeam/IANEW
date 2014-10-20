<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Issue Type</h3>
	
	<s:url var="urlIssueType" namespace="/admin" action="saveNewIssueType" includeContext="false"/>
	<s:url var="urlUpdateIssueType" namespace="/admin" action="updateIssueType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="issueType" class="toggled hideable">
			<s:form id="newIssueTypeForm" method="post" action="%{urlIssueType}">
				<s:label for="issueName" value="Name: "/>
				<s:textfield id="issueName" name="issueName" />
				<s:label for="issueDescription" value="Description" />
				<s:textarea id="issueDescription" name ="issueDescription" cols="70" rows="1"/>
				<sj:submit id="saveNewIssue" targets="tbodyIssueType" cssClass="two columns alpha" value="Save" clearForm="true"/>
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
						<%@include file="iterators/iterIssueTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyIssueType" value="Update changes" id="btnEditIssue" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>