<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 04/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 	- 	Quang Nhan
						Connect and retrieve data called by the action class and added 
		16/08/2014 -	Quang Nhan
						Moved javascript code to list.js file by 
		17/08/2014 -	Changed Date format display to dd MMM yyyy
		25/08/2014 -	Quang Nhan
						implemented the view function
	==============================================	
	Description: A jsp page that displays linked enquiries.
				Notes: the enquiry table has a field called parent enquiry
				when the user selects and add an enquiry, the query should
				check if that linked enquiry has a parent enquiry. If it does
				the system should search for all enquiries with the same 
				parent enquiry. It should add all enquiries with that same
				parent enquiry into the list as well (if it already is not).
------------------------------------------------------------------------------------------------>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<head>

</head>

<h3 class="sixteen columns" style="float:none;">Linked Enquiries</h3>
<s:div id="linkedEnquiriesField" cssClass="greybackground">

	<s:url id="urlELinked" namespace="/enquiry" action="getLinkedEnquiry" />
	
	<article id="itLikedEnquiries">
		<%@include file="iterLinkedEnquiries.jsp"%>
	</article>
	
	<s:hidden id="hiddenid" name="hiddenid" />
	<s:hidden name="iamodel.parentEnquiry" />
	
	<div>
		<div class="row">
			<div class="twelve columns alpha"><p></p></div>
			<input type="button" id="btnView" value="View" class="two columns"/>
			<input type="button" id="btnAddEnquiry" value="Add Enquiry" class="two columns omega"/>
		</div>
	</div>

	
	<script>
	$(function(){
		
		
		/* $('body').click(function(){
			hideSlidingPanel();
		}); */
		
		/* $('#slidingPanel').click(function(event){
			event.stopPropagation();
		}); */
		
		/* $("#aELinked").click(function(){
			//$("#slidingPanel").show("slide", {diretion: "right"}, 10);
			//$("#slidingPanel").hide();
			//hideSlidingPanel();
			showSlidingPanel();
		}); */

		$('#btnView').click(function(){
			var id = $("#hiddenid").val();
			$('#rightPopUp').show("slow");
			$('#rightPopUp').load("enquiry/getEnquiry.action?hiddenid=" + id +"&formTitle=Existing Enquiry" );
			
		});

		$('#btnAddEnquiry').click(function(){
			$("#linkedEnquiriesListDiv").show();
			$('#linkedEnquiriesListDiv').load("enquiryList/getLinkedEnquiriesList.action");
		});
	});
	</script>
</s:div>
