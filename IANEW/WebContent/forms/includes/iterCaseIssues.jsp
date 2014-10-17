<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.caseIssuesList" status="stat">
	<section class="secIssue sixteen columns curveBorder">
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<s:hidden name="iamodel.caseIssuesList[%{#stat.index}].id"/>
		<div class="row">
			<div class="five columns">
				<s:select list="issueSelectList" listValue="issueName" listKey="id" name="theIssueListId[%{#stat.index}]" headerKey="-1" headerValue="Select an Issue" />
			</div>
			<div class="six columns">
				<s:label for="completedDate" value="Issue Completed Date:"/>
				<s:date name="iamodel.caseIssuesList[%{#stat.index}].completedDate" format="dd/MM/yyyy"/>
			</div>
			<div class="four columns">
		    	<s:select list="caseIssueStatusSelectList" listValue="statusName" listKey="id" name="theIssueStatusList[%{#stat.index}]" headerKey="-1" headerValue="Select Issue Status" />
	    	</div>
		</div>
		
		<div class="textarea fifteen columns omega">
			<s:label for="issuedescription" value="Issue Description:" />
			<s:textarea cssClass="oneLineTextArea" name="iamodel.caseIssuesList[%{#stat.index}].comments"/> 
		</div>
	</section>
</s:iterator>