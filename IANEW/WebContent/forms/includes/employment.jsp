<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		01/09/2014 -	Quang Nhan
						Updated employment to support 1 to many and add Add Employment functionality
		08/09/2014 -	Quang Nhan
						changed all iamodel.contact to iamodel.contact
		29/09/2014 -	Quang Nhan modified select list to accommodate value by id rather than name
						Added img delete button and modified expand button
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<section>
<img src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Employment</h3>
<div class="greybackground">
<div id="employmentDiv" class="toggled hideable">	

	<article id="itEmployment">
		<%@include file="iterEmployments.jsp" %>
	</article>
	
	<!-- hidden field to be used as marker for next index up -->
	<s:if test="%{iamodel.contact.employmentsList.size > 0 }">
		<s:hidden id="employmentSize" name="iamodel.contact.employmentsList.size" value="%{iamodel.contact.employmentsList.size}"/>
		<s:set name="index" value="iamodel.contact.employmentsList.size" />
		<article id="artEmployment" class="hidden"> 
	</s:if>
	<s:else>
		<s:hidden id="employmentSize" name="iamodel.contact.employmentsList.size" value="0"/>
		<s:set name="index" value="0" />
		<article id="artEmployment" class="hidden">
	</s:else>
	<section class="secIssue sixteen columns curveBorder">
		<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
		<s:hidden name="iamodel.contact.employmentsList[%{#index}].id"/>
		<div class="row">
			<div class="four columns">
				<s:select list="employmentSelectList" listKey="id" listValue="employmentName" name="theEmploymentListId[%{#index}]" headerKey="-1" headerValue="Select Employment Type" />
			</div>
			<div class="inputfield four columns">
				<s:label for="workPhone" value="Work#:" />
				<div><s:textfield name="iamodel.contact.employmentsList[%{#index}].workphone" /></div>
			</div>
		</div>
		<div class="row">
			<div class="textarea fifteen columns">
				<s:label for="employmentComment" value="Comments:" /> 
				<div><s:textarea cssClass="multiLineTextArea" name="iamodel.contact.employmentsList[%{#index}].comments" /></div>
			</div>
		</div>
	</section>
	
	</article>
	
	<div class="row">
		<div class="fourteen columns alpha"><p></p></div>
		
		<!-- addNewRecord function is located in ianew.form.js -->
		<input type="button" id="btnAddIssue" value="Add Issue" class="two columns" onclick="addNewRecord('artEmployment', 'employmentSize', 'itEmployment' )"/>
	</div>
	
</div>
</div>
</section>
