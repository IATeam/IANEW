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
