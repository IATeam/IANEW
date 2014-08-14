<!-- 
	Created By Quang
	Created On
	Last Updated On
	Description:
	
	Notes: the enquiry table has a field called parent enquiry
	when the user selects and add an enquiry, the query should
	check if that linked enquiry has a parent enquiry. If it does
	the system should search for all enquiries with the same 
	parent enquiry. It should add all enquiries with that same
	parent enquiry into the list as well (if it already is not).
 -->

<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<head>

</head>

<h3 class="sixteen columns" style="float:none;">Linked Enquiries</h3>
<s:div cssClass="greybackground">

	<s:url id="urlELinked" namespace="/enquiry" action="getLinkedEnquiry" />
		
	

		<s:iterator value="linkedEnquiries">
			<section class="secLinkedEnquiries sixteen columns curveBorder">
				<s:div cssClass="textarea two columns">
					<s:label for="enquiryID" value="Enquiry#:" />
					<s:text id="enquiryID" name="id" />
				</s:div>
				<s:div cssClass="textarea two columns">
					<s:label for="date" value="Date:" />
					<s:date id="date" format="dd/MM/yyyy" name="updatedDateTime"/>
				</s:div>
				<div class="textarea eleven columns omega">
					<s:label for="description" value="Description:" />
					<div><s:textarea id="description" cssClass="multiLineTextArea" name="description" readonly="true"/></div>
				</div>
			</section>
		</s:iterator>
	
	<article id="artLinkedEnquiries" class="row">
	
		<%-- <sj:a id="aELinked" href="%{urlELinked}" targets="slidingPanel"> --%>
			<section class="secLinkedEnquiries sixteen columns curveBorder">
				<s:div cssClass="textarea two columns">
					<s:label for="enquiryID" value="Enquiry#:" />
					<s:text id="enquiryID" name="" />
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
		<%-- </sj:a> --%>
	</article>
	
	<div>
		<div class="row">
			<div class="twelve columns alpha"><p></p></div>
			<input type="button" id="btnOpen" value="View" class="two columns"/>
			<input type="button" id="btnAddEnquiry" value="Add Enquiry" class="two columns omega"/>
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
		
		$("#aELinked").click(function(){
			//$("#slidingPanel").show("slide", {diretion: "right"}, 10);
			//$("#slidingPanel").hide();
			//hideSlidingPanel();
			showSlidingPanel();
		});
	});
	</script>
</s:div>