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

	==============================================	
	Description: A jsp page that displays enquiry list for both new and existing
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Enquiry Form</title>
<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
	      media="all"/>
<script src="<s:url value='/js/validation/enquiryValidation.js' encode='false' includeParams='none'/>"></script>

<s:head/>

</head>
<body>
	<s:form id="enquiryForm" cssClass="cmxform form container" namespace='/enquiry' method="post" novalidate="novalidate">  
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Header of the form --------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="includes/formHeader.jsp" %>
		
		
		
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Content of the form -------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->		
	
		<%@include file="includes/formStatus.jsp" %>
		<%@include file="includes/summary.jsp" %>
		<%@include file="includes/personalDetails.jsp" %>
		<%@include file="includes/address.jsp" %>
		<%@include file="includes/referral.jsp" %>
		<%@include file="includes/employment.jsp" %>
		<%@include file="includes/disability.jsp" %>
		<%@include file="includes/issues.jsp" %>
		<%@include file="includes/linkedEnquiries.jsp" %>
		
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - footer for enquiry form ----------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
		<!-- 
		Note: each form will have its own footer settings so it is better to NOT to separate and
		create its own include file and referenced it here.
		 -->			
		<s:div cssClass="clear"></s:div>
		<footer>
			<s:div cssClass="row">
				<section class="six columns">
					<input type="button" class="three columns alpha" value="Cancel"/>
					<input type="button" class="three columns omega" value="New Enquiry" />
				</section>
				<section class="six columns"><p></p></section>
				<section class="four columns omega">
					<input type="button" value="Create Case" class="two columns alpha"/>
					<s:submit type="submit" cssClass="two columns omega" value="Save"/>
				</section>
			</s:div>
		</footer>
	</s:form>	
	<script>
	$(function(){
		alert("loaded")
	});
	if($("#formTitle").text() === "Existing Enquiry"){
		alert("existing")
		$("#enquiryForm").find("input").attr("readonly", "true");
		$("#enquiryForm").find('textarea').attr("readonly", "true");
		
	}
	
	</script>
</body>
</html>