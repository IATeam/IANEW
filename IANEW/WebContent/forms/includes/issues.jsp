<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		21/08/2014 -	Quang Nhan
						Added "Add Issue" button and functionality
		01/08/2014 -	Quang Nhan
						Reworked add issue function to have correct name attribute and functionality	
		18/09/2014 -	Quang Nhan Add validation refer to enquiryValidation.js file and fix index bugs
						when it is a new enquiry
						Added img delete button and modified expand button
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<section>
<img src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Issues</h3>
<div class="greybackground">
<div id="issuesDiv" class="toggled hideable">	
	<article id="itIssue">
		<%@include file="iterIssues.jsp" %>
	</article>
	
	<!-- hidden field to be used as marker for next index up -->
	
	
	<s:if test="%{iamodel.enquiryIssuesList.size > 0}">
		<s:hidden id="issueSize" name="iamodel.enquiryIssuesList.size" value="%{iamodel.enquiryIssuesList.size}"/>
		<s:set name="index" value="iamodel.enquiryIssuesList.size" />
		<article id="artIssue" class="hidden">
	</s:if>
	<s:else>
		<s:hidden id="issueSize" name="iamodel.enquiryIssuesList.size" value="0"/>
		<s:set name="index" value="iamodel.enquiryIssuesList.size" />
		<article id="artIssue"">
	</s:else>
		<section class="secIssue sixteen columns curveBorder row">
			<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
			<s:hidden name="iamodel.enquiryIssuesList[%{.enquiryIssuesList.size}].id"/>
			
			<div class="four columns">
				<s:select list="issueSelectList" listValue="issueName" listKey="id" name="theIssueListId[%{iamodel.enquiryIssuesList.size}]" value="iamodel.enquiryIssuesList.issue.issueName" headerKey="-1" headerValue="Select an Issue" />
			</div>
			
			<div class="textarea eleven columns omega">
				<s:label for="issuedescription" value="Issue Description:" />
				<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.enquiryIssuesList[%{iamodel.enquiryIssuesList.size}].comment"/> 
			</div>
		</section>
	</article> 
	<div class="row">
		<div class="fourteen columns alpha"><p></p></div>    
		<input type="button" id="btnAddIssue" value="Add Issue" class="two columns" onclick="addNewRecord('artIssue', 'issueSize', 'itIssue' )"/>
		
	</div>
	
</div>
</div>
</section>
