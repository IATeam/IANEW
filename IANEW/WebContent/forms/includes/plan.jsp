<!----------------------------------------------------------------------------------------------
	Created By: Kim To
	Created Date: 
	==============================================
	Updates:
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>	
	<h3 class="sixteen columns"  style="float:none;">Plan</h3>
	<img src="/IANEW/resources/images/srchicon.png" onclick="searchSupportAuthorised();" title="Search for Support or Authorised Person" class="button" >
	<img src="/IANEW/resources/images/eraseButton.png" onclick="clearSupportAuthorised();" title="Search for Support or Authorised Person" class="button" >
	<s:div id="planSearchDiv" cssClass="hidden"> 
		<%@include file="/forms/search/searchSupportAuthorised.jsp" %>
	</s:div>
	<div class="greybackground">
		<div id="planDiv" class="toggled hideable">	
			<fieldset>
				<div class="row">
					<div class="five columns">
						<s:select list="reviewFrequencyList" listValue="frequencyName" listKey="id" name="theReviewFrequency" headerKey="-1" headerValue="Select Review Frequency" />
					</div>
					<div class="four columns">
					<s:label for="createdDate" value="Created Date:" />
					    <s:date name="iamodel.plan.createdDateTime" format="dd/MM/yyyy"/>
				    </div>
				    <div class="three columns omega">
						<s:label for="completionDate" value="Completion Date:" />
					    <s:date name="iamodel.plan.closedDateTime" format="dd/MM/yyyy"/>
					</div>
					    <div class="four columns">
					    	<s:select list="planStatusSelectList" listValue="statusName" listKey="id" name="thePlanStatus" headerKey="-1" headerValue="Select Plan Status" />
					    </div>
				</div>
				<div class="row">
					<div class="inputfield four columns">
						<s:label for="lastReviewDate" value="Last Review Date:" />
						<div>
							<s:textfield cssClass="DateInputClass" name="iamodel.plan.lastReviewedDate" /> 
							<%-- <input type="date" name="lastReviewedDate" value="<s:property value="iamodel.plan.lastReviewedDate.toString()" />"> --%>
						</div>
					</div>
					<div class="inputfield four columns">
						<s:label for="planProvidedDate" value="Plan Provided Date:" />
						<div>
							<s:textfield cssClass="DateInputClass" name="iamodel.plan.providedPlanDate"/> 
							<%-- <input type="date" name="planProvidedDate" value="<s:property value="iamodel.plan.providedPlanDate.toString()"/>"> --%>
						</div>
					</div>
					<div class="inputfield four columns omega">
						<s:label for="consentSignedDate" value="Consent Signed Date:" />
						<div>
							<s:textfield cssClass="DateInputClass" name="iamodel.plan.consentSignedDate"/> 
							<%-- <input type="date" name="consentSignedDate" value="<s:property value="iamodel.plan.consentSignedDate.toString()"/>"> --%>
						</div>
					</div>
					<div class="inputfield four columns omega">
						<s:label for="authorisedByDate" value="Authorised Date:"/>
						<div>
							<s:textfield cssClass="DateInputClass" name="iamodel.plan.authorisedByDate"/> 
							<%-- <input type="date" name="authorisedByDate" value="<s:property value="iamodel.plan.authorisedByDate.toString()"/>"/> --%>
						</div>
					</div>
				</div>
				<%@include file="authorisedPerson.jsp" %>
				<%@include file="support.jsp" %>
				<div class="row">
					<div class="textarea sixteen columns omega">
						<s:label for="notes" value="Notes:" />
						<s:textarea id="notes" cssClass="oneLineTextArea" name="iamodel.plan.notes"/> 
					</div>
				</div>
			</fieldset>
			<br>
			<%@include file="planDeveloper.jsp" %>
			<br>
			<%@include file="goals.jsp" %>
			<br>
			<%@include file="risks.jsp" %>
			
		</div>
	</div>
</section>
<script>
	function searchSupportAuthorised() {
		$("#planSearchDiv").removeClass("hidden");
	}
	
	function clearSupportAuthorised(){
		// need confirmation
		var search;
		$("#planSearchDiv").removeClass("hidden");
		
		if($("#radioSupport").is(":checked")) {
			if (confirm("Are you sure you want to remove Support person from this case?")) {
				$("#planSearchDiv").addClass("hidden");
				$("#supportPersonDiv").load("/IANEW/case/clearSupportContact.action");
			}
		} else {
			if (confirm("Are you sure you want to remove Autorised person from this case?")) {
				$("#planSearchDiv").addClass("hidden");
				$("#authorisedPersonDiv").load("/IANEW/case/clearAuthorisedContact.action");
			}
		}
		
	}
</script>
