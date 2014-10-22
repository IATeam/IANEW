<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 25/08/2014
	==============================================
	Updates:
		02/08/2014 -	Quang Nhan
						Separated the components into its own jsps to be included in this file
						Created and referenced a form css style sheet
		05/08/2014 -	Quang Nhan
						Reseharched and added Skeleton styling and addjusted custom css. Skeleton is 
						for mobile compatibility
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 - 	Quang Nhan
						Connect and retrieve data called by the EnquiryAction class
		16/08/2014 -	Quang Nhan
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
				   -	Added Javascript functionality to have read only to existing enquiry
				   -	Separate the form header into its own jsp file and included here
		25/08/2014 -	Quang Nhan
						Pulled the form footer out of the enquiryForm tags and placed it at the bottom
						Implement readonly javascript for existing enquiry.
		01/09/2014 -	Include a new javascript ianew.form.js
		13/09/2014 - 	David Forbes
						Added OnClick method to buttons 
		14/09/2014 -	Quang Revised the function to remove null sections and definition when the form is submitted
		16/09/2014 -	Rework the submit to allow Jquery's validation
		25/09/2014 -	Quang Nhan
						Moved referral section above summary requested by client
	==============================================	
	Description: A jsp page that displays enquiry list for both new and existing
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<s:head/>
<title>Enquiry Form</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/validation/enquiryValidation.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.form.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>" ></script>
<script src="<s:url value='/js/popUpBoxAction.js' encode='false' includeParams='none'/>" ></script>
<s:head/>

</head>
<body>
	

	<s:div cssClass="form container">
	<s:set var="formType">enquiry</s:set>
		<s:form id="enquiryForm" action="saveUpdateEnquiry" cssClass="cmxform" namespace='/enquiry' method="post" validate="novalidate"> 
			
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Header of the form --------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
			<%@include file="includes/formHeader.jsp" %>
			
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Content of the form -------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->		
			<%@include file="includes/formStatus.jsp" %>
			<%@include file="includes/referral.jsp" %>
			<%@include file="includes/summary.jsp" %>
			
			<s:div id="contactInfo">
				<%@include file="includes/contactInfo.jsp" %>
			</s:div>
			
			<%@include file="includes/issues.jsp" %>
			
			<s:div id="linkedEnquiriesDiv">
				<%@include file="includes/linkedEnquiries.jsp" %>
			</s:div>
			
			<s:div id="linkedEnquiriesListDiv" style="box-shadow: 5px 5px 0 grey;"/>
			<s:div cssClass="clear"></s:div>
			
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - footer for enquiry form ----------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
			<footer>
				<s:div cssClass="row" cssStyle="padding-top:10px;">
					<section class="six columns">
						<input id="btnCancel" type="button" class="three columns alpha" value="Cancel" onclick="confirmAction('Are you sure you want to Cancel?', 'home', 'home')"/>
						<input id="btnNewEnquiry" type="button" class="three columns omega" value="New Enquiry" onclick="confirmAction('Are you sure you want to create a new enquiry?', 'enquiry', 'newEnquiry')"/>
					</section>
						<s:if test="%{formTitle == 'Existing Enquiry'}">
							<section class="four columns"><p></p></section>
							<section class="six columns omega">
							<s:if test="%{iamodel.individualCasesList.size == 0}">
								<input type="button" id="createCase" class="three columns alpha" value="Create Case" />
							</s:if>
							<s:else>
								<s:hidden id="caseId" name="iamodel.individualCasesList[0].id" value="%{iamodel.individualCasesList[0].id}"></s:hidden>
								<input type="button" id="viewCase" class="three columns alpha" value="View Case" />
							</s:else>
							<s:submit name="submit" cssClass="three columns omega" value="Submit" onclick="confirmAction('Are you sure you want to save the enquiry?', 'enquiry', 'saveUpdateEnquiry')"/>
							</section>
						</s:if>
						<s:else>
							<section class="seven columns"><p></p></section>
							<section class="three columns omega">
								<s:submit name="submit" cssClass="three columns omega" value="Submit" onclick="confirmAction('Are you sure you want to save the enquiry?', 'enquiry', 'saveUpdateEnquiry')"/>
							</section>
						</s:else>
				</s:div>
			</footer>
		</s:form>	
		<!-- 
		Note: each form will have its own footer settings so it is better to NOT to separate and
		create its own include file and referenced it here.
		 -->			

	</s:div>
	
	<script>
		$("#btnNewEnquiry").click(function(){
			var contactId = $("input[name='iamodel.contact.id']").val();

			$("#formDiv").load("enquiry/newEnquiry.action?contactid=" + contactId);
			
		});

	$(function() {
		initialisePrimaryDisability();
		initialiseNewSection("artIssue", "itIssue");
		initialiseNewSection("artAddress", "itAddress");
		initialiseNewSection("artEmployment", "itEmployment");
		initialiseNewSection("artDisability", "itDisability");
	});
	$('#createCase').click(function(){
		var enquiryid = $('#hiddenid').val();
		$("#formDiv").load("/IANEW/case/newCase.action?hiddenId=0&enquiryId=" + enquiryid);
	});
	
	$('#viewCase').click(function(){
		var caseid = $('#caseId').val();
		$("#formDiv").load("/IANEW/case/getExistingCase.action?hiddenid=" + caseid);
	});
	</script>
	
</body>
</html>
