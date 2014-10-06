<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/09/2014
	==============================================
	Updates:
		29/08/2014 -	Quang Nhan added img delete button
	==============================================	
	Description: A jsp page that displays iterator for issues
	
------------------------------------------------------------------------------------------------>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.enquiryIssuesList" status="stat">
	<section class="secIssue sixteen columns curveBorder">
		<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
		<s:hidden name="iamodel.enquiryIssuesList[%{#stat.index}].id"/>
		
		<div class="four columns">
			<s:select list="issueSelectList" listValue="issueName" listKey="id" name="theIssueListId[%{#stat.index}]" headerKey="-1" headerValue="Select Issue" />
		</div>
		
		<div class="textarea eleven columns omega">
			<s:label for="issuedescription" value="Issue Description:" />
			<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.enquiryIssuesList[%{#stat.index}].comment"/> 
		</div>
	</section>
</s:iterator>