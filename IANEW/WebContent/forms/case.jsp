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
						Connect and retrieve data called by the CaseAction class
		16/08/2014 -	Quang Nhan
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
				   -	Added Javascript functionality to have read only to existing case
				   -	Separate the form header into its own jsp file and included here

	==============================================	
	Description: A jsp page that displays case list for both new and existing
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>

<html>
<head>
	<s:head/>
 	<script src="<s:url value='/js/jquery/jquery-ui.min.js' encode='false' includeParams='none'/>"></script>
	<title>Case Form</title>
	<link href="<s:url value='/styles/ianew.form.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
		      media="all"/>
	<link href="<s:url value='/styles/import/skeleton.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
		      media="all"/>
		
	<script src="<s:url value='/js/jquery/jquery.validate.js' encode='false' includeParams='none'/>" ></script> 
		      
	<script src="<s:url value='/js/ianew.lists.js' encode='false' includeParams='none'/>"></script>
	<script src="<s:url value='/js/ianew.form.js' encode='false' includeParams='none'/>" ></script> 
	<script src="<s:url value='/js/validation/caseValidation.js' encode='false' includeParams='none'/>" ></script> 
	
</head>
<body>
<s:div cssClass="form container">
	<s:set var="formType">case</s:set>
	<s:form id="caseForm" cssClass="cmxform" namespace="/case" method="post" action="saveUpdateCase">  
		<s:hidden name="iamodel.contact.id" />
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Header of the form --------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->	
		<%@include file="includes/formHeader.jsp" %>
		
		
		
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- Content of the form -------------------------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->		
		<%@include file="includes/formStatus.jsp" %>
		<%@include file="includes/caseSummary.jsp" %>
		<%@include file="includes/advocateDetails.jsp" %>
		<s:div id="contactInfo">
			<%@include file="includes/contactInfo.jsp" %>
		</s:div>
		<%@include file="includes/plan.jsp" %>
		<%@include file="includes/caseIssues.jsp" %>
		<%@include file="includes/communications.jsp" %>
		<%@include file="includes/linkedCases.jsp" %>
		<s:div id="linkedEnquiriesDiv">
				<%@include file="includes/linkedEnquiries.jsp" %>
			</s:div>
			
			<s:div id="linkedEnquiriesListDiv" style="box-shadow: 5px 5px 0 grey;"/>
		
<!-- ---------------------------------------------------------------------------------------------- -->
<!-- iterator - footer for case form ----------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------------------------------- -->
		<!-- 
		Note: each form will have its own footer settings so it is better to NOT to separate and
		create its own include file and referenced it here.
		 -->			
		<s:div cssClass="clear"></s:div>
		<footer>
			<s:div cssClass="row" cssStyle="padding-top:10px;">
				<section class="six columns">
					<input type="button" class="three columns alpha" value="Cancel"/>
					<input type="button" class="three columns omega" value="New Case" />
				</section>
				<section class="seven columns"><p></p></section>
				<section class="three columns omega">
  					<s:submit name="submit" cssClass="three columns omega" value="Submit" onclick="checkForm()"/>
 				</section>
			</s:div>
		</footer>
	</s:form>	
	</s:div>
	<script>
	
	$(function() {
		initialiseNewSection("artAddress", "itAddress");
		initialiseNewSection("artDisability", "itDisability");
		initialiseNewSection("artEmployment", "itEmployment");
		initialiseNewSection("artIssue", "itIssue");
		initialiseNewSection("artCommunication", "itCommunication");
		initialiseNewSection("artDeveloper", "itDeveloper");
		initialiseNewSection("artGoal", "itGoal");
		initialiseNewSection("artRisk", "itRisk");
		initialisePrimaryDisability();
		initialiseCaseCommunications();
		
		$("#btnNewIssue").click(function(){ 
			$("#ulistIssues li").first().clone().appendTo("#ulistIssues");
		});
		
		initialiseDatePicker();
		
		
	});
	
	function checkForm(){
		//removeNullAndUpdateIndex($("#artAddress"), $("#itAddress"), $("#addressSize"));
		//removeNullAndUpdateIndex($("#artDisability"), $("#itDisability"), $("#disabilitySize"));
		//removeNullAndUpdateIndex($("#artIssue"), $("#itIssue"), $("#issueSize"));
		//removeNullAndUpdateIndex($("#artEmployment"), $("#itEmployment"), $("#employmentSize"));
		//removeNullAndUpdateIndex($("#artGoal"), $("#itGoal"), $("#goalSize"));
		//removeNullAndUpdateIndex($("#artRisk"), $("#itRisk"), $("#riskSize")); 
		//removeNullAndUpdateIndex($("#artCommunication"), $("#itCommunication"), $("#communicationSize"));
		//removeNullAndUpdateIndex($("#artDeveloper"), $("#itDeveloper"), $("#planDeveloperSize"));
		//setSQLDateFormat();
		validated();
		//$("#caseForm").submit();
	}
	</script>
</body>
</html>
