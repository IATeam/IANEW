<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 04/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
	==============================================	
	Description: A jsp page that displays a list of cases
				Notes: the case table has a field called parent case
				when the user selects and add an case, the query should
				check if that linked case has a parent case. If it does
				the system should search for all cases with the same 
				parent case. It should add all cases with that same
				parent case into the list as well (if it already is not).
------------------------------------------------------------------------------------------------>


<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<head>

</head>

<h3 class="sixteen columns" style="float:none;">Linked Cases</h3>
<s:div cssClass="greybackground">

	<s:url id="urlCLinked" namespace="/case" action="getLinkedCase" />
		
		<s:iterator value="linkedCasesSet">
			<section class="secLinkedCases sixteen columns curveBorder">
				<s:div cssClass="textarea two columns">
					<s:label for="caseID" value="Case#:" />
					<s:text var="caseID" name="id" />
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label for="date" value="Date:" />
					<s:date var="date" format="dd/MM/yyyy" name="updatedDateTime"/>
				</s:div>
				<div class="textarea eleven columns omega">
					<s:label for="description" value="Description:" />
					<div><s:textarea id="description" cssClass="multiLineTextArea" name="description" readonly="true"/></div>
				</div>
			</section>
		</s:iterator>
	
	<%-- <article id="artLinkedCases" class="row">
	
		<sj:a id="aELinked" href="%{urlELinked}" targets="slidingPanel">
			<section class="secLinkedCases sixteen columns curveBorder">
				<s:div cssClass="textarea two columns">
					<s:label for="caseID" value="Case#:" />
					<s:text id="caseID" name="" />
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label for="date" value="Date:" />
					<s:text id="date" name="" />
				</s:div>
				<div class="textarea eleven columns omega">
					<s:label for="description" value="Description:" />
					<div><s:textarea id="description" cssClass="multiLineTextArea" name="" readonly="true"/></div>
				</div>
			</section>
		</sj:a>
	</article> --%>
	
	<div>
		<div class="row">
			<div class="twelve columns alpha"><p></p></div>
			<input type="button" id="btnOpen" value="View" class="two columns"/>
			<input type="button" id="btnAddCase" value="Add Case" class="two columns omega"/>
		</div>
	</div>

	
	<script>
	$(function(){
		$("#btnNewIssue").click(function(){ 
			$("#ulistIssues li").first().clone().appendTo("#ulistIssues");
		});
		
		$('body').click(function(){
			
			hideSlidingPanel();
		});
		
		$('#slidingPanel').click(function(event){
			event.stopPropagation();
		});
		
		$("#aCLinked").click(function(){
			//$("#slidingPanel").show("slide", {diretion: "right"}, 10);
			//$("#slidingPanel").hide();
			//hideSlidingPanel();
			showSlidingPanel();
		});
	});
	</script>
</s:div>