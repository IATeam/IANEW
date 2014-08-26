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

<h3 class="sixteen columns" style="float:none;">Issues</h3>
<s:div cssClass="greybackground">
	<%-- <s:if test="" > --%>
	<article id="itIssue">
		<s:iterator value="issueSet">
			<section class="secIssue sixteen columns curveBorder">
				<div class="four columns"><s:select list="issueSelectList.{issueName}" name="getIssue().issueName" headerKey="-1" headerValue="Select an Issue" /></div>
				<div class="textarea eleven columns omega">
					<s:label for="issuedescription" value="Issue Description:" />
					<s:textarea id="" cssClass="oneLineTextArea" name="comment"/> 
				</div>
			</section>
		</s:iterator>
	</article>
	
	
	<article id="artIssue" class="row" style="visibility: hidden; display: none;">
		<section class="secIssue sixteen columns curveBorder">
			<div class="four columns"><s:select list="issueSelectList.{issueName}" name="getIssue().issueName" headerKey="-1" headerValue="Select an Issue" /></div>
			<div class="textarea eleven columns omega">
				<s:label for="issuedescription" value="Issue Description:" />
				<s:textarea id="" cssClass="oneLineTextArea" name="" /> 
			</div>
		</section>
	</article>
	<div class="row">
		<input type="button" id="btnNewIssue" value="New Issue" class="two columns" />
		<div class="twelve columns alpha"><p></p></div>
		<input type="button" id="btnAddIssue" value="Add Issue" class="two columns" />
	</div>
	
	<script>
	$(function(){
		$("#btnAddIssue").click(function(){ 
			$("#artIssue section").clone().appendTo("#itIssue");
		});
	});
	</script>
</s:div>
