<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
<<<<<<< HEAD
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
=======
<<<<<<< HEAD
		21/08/2014 -	Quang Nhan
						Added "Add Issue" button and functionality
						
=======
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>

<h3 class="sixteen columns" style="float:none;">Communications</h3>
<s:div cssClass="greybackground">
	<%-- <s:if test="" > --%>
	<article id="itCommunication">
		<s:iterator value="communicationSet">		
			<section class="secIssue sixteen columns curveBorder">
			<div class="row">
			<div class="four columns"><s:select list="issueSelectList.{issueName}" name="" headerKey="-1" headerValue="Select an Issue" /></div>
			<s:if test="%{#formType=='case'}">
				<div class="three columns">
				<s:label for="createdDate" value="Created Date:" />
				    <s:date name="createdDate" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
				<s:label for="createdBy" value="Created By:" />
				    <s:date name="createdBy" format="dd/MM/yyyy"/>
			    </div>
			    <div class="three columns">
					<s:label for="completedDate" value="Completed Date:"  />
				    <s:date name="completedDate" format="dd/MM/yyyy"/>
			    </div>
				    <div class="three columns"><s:select list="issueSelectList.{issueName}" value="issue" name="" headerKey="-1" headerValue="Status" /></div>
				</div>
				<div class="row">
					<div class="textarea fifteen columns omega">
					<s:label for="comments" value="Comments:" />
					<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
					</div>
				</div>
			</s:if>
			<s:elseif test="%{#formType=='enquiry'}">
				<div class="textarea eleven columns omega">
					<s:label for="issuedescription" value="Issue Description:" />
					<s:textarea id="" cssClass="oneLineTextArea" name="" /> 
			</s:elseif>
		</section>
		</s:iterator>
	</article>
	
	<article id="artCommunication" class="row" style="visibility: hidden; display: none;">
		<section class="secIssue sixteen columns curveBorder">
			<div class="row">
			<div class="three columns"><s:select list="issueSelectList.{issueName}" name="" headerKey="-1" headerValue="Communication Type" /></div>
			<div class="three columns">
			<s:label for="createdDate" value="Created Date:" />
			    <s:date name="createdDate" format="dd/MM/yyyy"/>
		    </div>
		    <div class="three columns">
			<s:label for="createdBy" value="Created By:" />
			    <s:date name="createdBy" format="dd/MM/yyyy"/>
		    </div>
		    <div class="inputfield four columns omega">
				<s:label for="communicationDate" value="Communication Date:" />
				<div><input type="date" id="communicationDate" name=""></div>
			</div>
			    <div class="two columns"><s:select list="issueSelectList.{issueName}" value="issue" name="" headerKey="-1" headerValue="Time Spent" /></div>
			</div>
			<div class="row">
				<div class="textarea thirteen columns omega">
				<s:label for="comments" value="Comments:" />
				<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
				</div>
				<input type="button" id="btnImportant" value="!!IMPORTANT!!" class="two columns" onclick="importantDiv(this)"/>
			</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddCommunication" value="Add Communication" class="three columns" />
	</div>
	
	<script>
	$(function(){
		$("#btnAddCommunication").click(function(){ 
			$("#artCommunication section").clone().appendTo("#itCommunication");
		});
	});
	</script>
</s:div>
