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

	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<h3 class="sixteen columns" style="float:none;">Issues</h3>
<s:div cssClass="greybackground">
	<article id="itIssue">
		<s:iterator value="iamodel.enquiryIssuesList" status="stat">
			<section class="secIssue sixteen columns curveBorder">
				<s:hidden name="iamodel.enquiryIssuesList[%{#stat.index}].id"/>
				<div class="four columns"><s:select list="issueSelectList.{issueName}" name="iamodel.enquiryIssuesList[%{#stat.index}].issue.issueName" headerKey="-1" headerValue="Select an Issue" /></div>
				<div class="textarea eleven columns omega">
					<s:label for="issuedescription" value="Issue Description:" />
					<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.enquiryIssuesList[%{#stat.index}].comment"/> 
				</div>
			</section>
		</s:iterator>
	</article>
	
	<!-- hidden field to be used as marker for next index up -->
	<s:textfield id="issueSize" name="iamodel.enquiryIssuesList.size" value="%{iamodel.enquiryIssuesList.size}"/>
	
	<!-- <s:if test="%{iamodel.enquiryIssuesList.size > 0}"><article id="artIssue" class="hidden"></s:if>
	<s:else><article id="artIssue""></s:else>
		<section class="secIssue sixteen columns curveBorder row">
			<s:hidden name="iamodel.enquiryIssuesList[%{.enquiryIssuesList.size}].id"/>
			<div class="four columns"><s:select list="issueSelectList.{issueName}" name="iamodel.enquiryIssuesList[%{.enquiryIssuesList.size}].issue.issueName" headerKey="-1" headerValue="Select an Issue" /></div>
			<div class="textarea eleven columns omega">
				<s:label for="issuedescription" value="Issue Description:" />
				<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.enquiryIssuesList[%{iamodel.enquiryIssuesList.size}].comment"/> 
			</div>
		</section>
	</article> -->
	<div class="row">
		<input type="button" id="btnNewIssue" value="New Issue Type" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		<input type="button" id="btnAddIssue" value="Add Issue" class="two columns" onclick="addNewRecord('artIssue', 'issueSize', 'itIssue' )"/>
		
	</div>
	
</s:div>
