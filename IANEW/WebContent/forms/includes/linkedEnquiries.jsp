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
<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">Linked Enquiries</h3>
	<div class="greybackground">
		<div id="linkedEnquiriesDiv" class="toggled hideable">	
			<s:if test="%{#formType=='case'}">
				<s:hidden id="formType" value="case"/>
				<s:if test="%{iamodel.relatedEnquiry.id != null}">
					<section class="secLinkedEnquiries sixteen columns curveBorder"  onclick="selectEnquiry(this);">
						<s:hidden id="relatedEnquiryId" name="relatedEnquiryId" value="%{iamodel.relatedEnquiry.id}"/>
						<s:div cssClass="textarea one columns">
							<s:label value="E#:" />
							<s:div cssClass="id">
								<s:property value="%{iamodel.relatedEnquiry.id}"/>
							</s:div>
						</s:div>
						<s:div cssClass="textarea three columns">
							<s:label for="date" value="Date:" />
							<s:date name="iamodel.relatedEnquiry.createdDateTime" format="dd MMM yyyy"/>
						</s:div>
						<div class="textarea eleven columns omega">
							<s:label for="description" value="Description:" />
							<div><s:textarea id="description" cssClass="multiLineTextArea" name="iamodel.relatedEnquiry.description" readonly="true"/></div>
						</div>
					</section>
				</s:if>
			</s:if>
			<s:else>
				<s:url id="urlELinked" namespace="/enquiry" action="getLinkedEnquiry" />
				<article id="itLikedEnquiries">
				<s:iterator value="linkedEnquiriesList" status="stat">
					<s:hidden id="relatedEnquiryId" name="relatedEnquiryId" value="%{id}"/>
					<section class="secLinkedEnquiries sixteen columns curveBorder"  onclick="selectEnquiry(this)">
						<s:div cssClass="textarea one columns">
							<s:label value="E#:" />
							<s:div cssClass="id"><s:property  value="id"/></s:div>
						</s:div>
						<s:div cssClass="textarea three columns">
							<s:label for="date" value="Date:" />
							<!-- <s:property value="updatedDateTime"/> -->
							<s:date name="updatedDateTime" format="dd MMM yyyy"/>
						</s:div>
						<div class="textarea eleven columns omega">
							<s:label for="description" value="Description:" />
							<div><s:textarea id="description" cssClass="multiLineTextArea" name="description" readonly="true"/></div>
						</div>
					</section>
				</s:iterator>
				</article>
			</s:else>
	
	
	
	<s:hidden id="hiddenid" name="hiddenid" />
	<s:hidden name="iamodel.parentEnquiry" />
	
	<div>
		<div class="row">
			<div class="ten columns alpha"><p></p></div>
			<input type="button" id="btnView" value="View" class="three columns"/>
			<input type="button" id="btnLinkEnquiry" value="Link" class="three columns omega"/>
		</div>
	</div>

	<script>
	$(function(){
		
		$("#btnView").click(function() {
			var hiddenid;
			$(".secLinkedEnquiries").each(function() {
				if ($(this).hasClass("listSelected")) {
					hiddenid= $("#relatedEnquiryId").val();
				}
			});
			alert(hiddenid);
			
			if (hiddenid != null) {
				$("#formDiv").load("/IANEW/enquiry/getEnquiry.action?hiddenid=" + hiddenid);
			} else {
				alert("No Enquiry is selected");
			}
		});
		
		$('#btnLinkEnquiry').click(function(){
			alert($("#formType").val());
 			$("#linkedEnquiriesListDiv").show();
			$('#linkedEnquiriesListDiv').load("/IANEW/enquiryList/getLinkedEnquiriesList.action?formType=" + $("#formType").val());
		});
	}); 
	

	function selectEnquiry(section){
		$(".secLinkedEnquiries").each(function() {
			$(this).removeClass("listSelected");
		});
		$(section).addClass("listSelected");
	}
	
	
	</script>
</div>
</div>
</section>
