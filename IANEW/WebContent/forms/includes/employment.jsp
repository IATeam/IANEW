<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		01/09/2014 -	Quang Nhan
						Updated employment to support 1 to many and add Add Employment functionality
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<h3 class="sixteen columns" style="float:none;">Employment</h3>
<s:div cssClass="greybackground">
	<article id="itEmployment">
		<s:iterator value="ccontact.employmentsList" status="stat">
			<section class="secIssue sixteen columns curveBorder">
				<s:hidden name="ccontact.employmentsList[%{#stat.index}].id"/>
				<div class="row">
					<div class="four columns"><s:select list="employmentSelectList.{employmentName}" name="ccontact.employmentsList[%{#stat.index}].employmentType.employmentName" headerKey="-1" headerValue="Select Employment Type" /></div>
					<div class="inputfield four columns">
						<s:label for="workPhone" value="Work#:" />
						<div><s:textfield name="ccontact.employmentsList[%{#stat.index}].workphone" /></div>
					</div>
				</div>
				<div class="row">
					<div class="textarea fifteen columns">
						<s:label for="employmentComment" value="Comments:" /> 
						<div><s:textarea cssClass="multiLineTextArea" name="ccontact.employmentsList[%{#stat.index}].comments" /></div>
					</div>
				</div>
			</section>
		</s:iterator>
	</article>
	
	<!-- hidden field to be used as marker for next index up -->
	<s:textfield id="employmentSize" name="ccontact.employmentsList.size" value="%{ccontact.employmentsList.size}"/>
	
	<s:if test="%{ccontact.employmentsList.size > 0 }"><article id="artEmployment" class="hidden"></s:if>
	<s:else><article id="artEmployment"></s:else>
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="ccontact.employmentsList[%{ccontact.employmentsList.size}].id"/>
		<div class="row">
			<div class="four columns"><s:select list="employmentSelectList.{employmentName}" name="ccontact.employmentsList[%{ccontact.employmentsList.size}].employmentType.employmentName" headerKey="-1" headerValue="Select Employment Type" /></div>
			<div class="inputfield four columns">
				<s:label for="workPhone" value="Work#:" />
				<div><s:textfield name="ccontact.employmentsList[%{ccontact.employmentsList.size}].workphone" /></div>
			</div>
		</div>
		<div class="row">
			<div class="textarea fifteen columns">
				<s:label for="employmentComment" value="Comments:" /> 
				<div><s:textarea cssClass="multiLineTextArea" name="ccontact.employmentsList[%{ccontact.employmentsList.size}].comments" /></div>
			</div>
		</div>
	</section>
	
	</article>
	
	<div class="row">
		<input type="button" id="btnNewIssue" value="New Emp Type" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		
		<!-- addNewRecord function is located in ianew.form.js -->
		<input type="button" id="btnAddIssue" value="Add Issue" class="two columns" onclick="addNewRecord('artEmployment', 'employmentSize', 'itEmployment' )"/>
		
	</div>
	
</s:div>
