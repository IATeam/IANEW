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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- <script>
function changeContact(selectedPerson) {
	var selectedContact = $(selectedPerson).val();
	var pathA = $(selectedPerson).parent("div").parent("div").parent("fieldset").children("div").children("div").children("div");
	var pathB = $(selectedPerson).parent("div").parent("div").parent("fieldset").children("div").children("div");

	if (selectedContact == -1)
	{
		 $(pathB).children("#titleContact").val("-1");
		 $(pathA).children("#firstNameContact").val("");
		 $(pathA).children("#otherNameContact").val("");
		 $(pathA).children("#lastNameContact").val("");
		 $(pathB).children("#genderContact").val("-1");
		 $(pathA).children("#birthDateContact").val("");
		 $(pathA).children("#identificationContact").val("");
		 $(pathB).children("#culturalBackgroundContact").val("-1");
		 $(pathA).children("#culturalBackgroundCommentsContact").val("");
		 $(pathA).children("#emailContact").val("");
		 $(pathA).children("#mobileContact").val("");
	}
	
    <s:iterator var="contact" value="advocateSelectList">
    	var fullname = "<s:property value='#contact.lastname'/>" + ", " + "<s:property value='#contact.firstname'/>";
    	if(selectedContact == fullname)
    	{
    	    <s:iterator var="title" value="titleSelectList">
	    		if("<s:property value='#contact.titleType.name'/>" == "<s:property value='#title.name'/>")
	    		{
	    			$(pathB).children("#titleContact").val("<s:property value='#title.name'/>");
	    		}
    	    </s:iterator>
    	    $(pathA).children("#firstNameContact").val("<s:property value='#contact.firstname'/>");
    	    $(pathA).children("#otherNameContact").val("<s:property value='#contact.othername'/>");
    	    $(pathA).children("#lastNameContact").val("<s:property value='#contact.lastname'/>");
			<s:iterator var="gender" value="genderSelectList">
	    		if("<s:property value='#contact.genderType.genderName'/>" == "<s:property value='#gender.genderName'/>")
	    		{
	    			$(pathB).children("#genderContact").val("<s:property value='#gender.genderName'/>");
	    		}
	    	</s:iterator>
	    	$(pathA).children("#birthDateContact").val("<s:property value='#contact.getDateString()'/>");
	    	$(pathA).children("#identificationContact").val("<s:property value='#contact.identification'/>");
				<s:iterator var="culturalBackground" value="culturalBackgroundSelectList">
    		if("<s:property value='#contact.culturalBackground.culturalBackgroundName'/>" == "<s:property value='#culturalBackground.culturalBackgroundName'/>")
    		{
    			$(pathB).children("#culturalBackgroundContact").val("<s:property value='#culturalBackground.culturalBackgroundName'/>");
    		}
    		</s:iterator>
    		$(pathA).children("#culturalBackgroundCommentsContact").val("<s:property value='#contact.culturalBackgroundComment'/>");
    		$(pathA).children("#emailContact").val("<s:property value='#contact.email'/>");
    		$(pathA).children("#mobileContact").val("<s:property value='#contact.mobilephone'/>");

    	}
    </s:iterator>
}
</script> --%>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>	<h3 class="sixteen columns"  style="float:none;">Plan</h3>
<!-- 	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
 -->	
<div class="greybackground">
<div id="linkedEnquiriesDiv" class="toggled hideable">	
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
							<s:textfield cssClass="DateInputClass" name="iamodel.plan.lastReviewedDate"/> 
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
				<div class="row">
					<div class='inputfield four columns'>
						<s:label for="firstNameContact" value="Authorised First Name:" />
						<div><s:textfield id="authorisedFirstName" name="iamodel.plan.authorisedBy.firstname" ></s:textfield></div>
					</div>
					<div class="inputfield four columns">
						<s:label for="otherNameContact" value="Authorised Other Name:" />
						<div><s:textfield id="authorisedOtherName" name="iamodel.plan.authorisedBy.othername"></s:textfield></div>
					</div>
					
					<div class="inputfield four columns omega">
						<s:label for="lastNameContact" value="Authorised Last Name:" />
						<div><s:textfield id="authorisedLastName" name="iamodel.plan.authorisedBy.lastname"></s:textfield></div>
					</div>
					<div class="inputfield four columns omega">
						<s:label for="mobileContact" value="Authorised Mobile#:" />
						<div><s:textfield id="authorisedMobile" name="iamodel.plan.authorisedBy.mobilephone" ></s:textfield></div>
					</div>
				</div>
				<div class="row">
					<div class='inputfield four columns'>
									<s:label for="firstNameContact" value="Support First Name:" />
									<div><s:textfield id="supportFirstName" name="iamodel.plan.supportPerson.firstname" ></s:textfield></div>
								</div>
								<div class="inputfield four columns">
									<s:label for="otherNameContact" value="Support Other Name:" />
									<div><s:textfield id="supportOtherName" name="iamodel.plan.supportPerson.othername"></s:textfield></div>
								</div>
								
								<div class="inputfield four columns omega">
									<s:label for="lastNameContact" value="Support Last Name:" />
									<div><s:textfield id="supportLastName" name="iamodel.plan.supportPerson.lastname"></s:textfield></div>
				</div>
				
				<div class="inputfield four columns omega">
									<s:label for="mobileContact" value="Support Mobile#:" />
									<div><s:textfield id="supportMobile" name="iamodel.plan.supportPerson.mobilephone" ></s:textfield></div>
								</div>
				</div>
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
