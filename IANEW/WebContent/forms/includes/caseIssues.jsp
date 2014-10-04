<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Issues</h3>
<div class="greybackground">
<div id="caseIssuesDiv" class="toggled hideable">		
<article id="itIssue">
		<%@include file="iterCaseIssues.jsp" %>
	</article>
	
	<!-- hidden field to be used as marker for next index up -->
	
	
	<s:if test="%{iamodel.caseIssuesList.size > 0}">
		<s:hidden id="issueSize" name="iamodel.caseIssuesList.size" value="%{iamodel.caseIssuesList.size}"/>
		<s:set name="index" value="iamodel.caseIssuesList.size" />
		<article id="artIssue" class="hidden">
	</s:if>
	<s:else>
		<s:hidden id="issueSize" name="iamodel.caseIssuesList.size" value="0"/>
		<s:set name="index" value="iamodel.caseIssuesList.size" />
		<article id="artIssue"">
	</s:else>
		<section class="secIssue sixteen columns curveBorder row">
			<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="return false;" class="undoButton"/>
		
			<s:hidden name="iamodel.caseIssuesList[%{.caseIssuesList.size}].id"/>
			
			<div class="four columns">
				<s:select list="issueSelectList" listValue="issueName" listKey="id" name="theIssueListId[%{iamodel.caseIssuesList.size}]" value="iamodel.caseIssuesList.issue.issueName" headerKey="-1" headerValue="Select an Issue" />
			</div>
			
			<div class="textarea eleven columns omega">
				<s:label for="issuedescription" value="Issue Description:" />
				<s:textarea id="" cssClass="oneLineTextArea" name="iamodel.caseIssuesList[%{iamodel.caseIssuesList.size}].comments"/> 
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