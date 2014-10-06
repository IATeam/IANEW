<!-- 
 Created By: Kim To
 Created Date: 18/09/2014
 ==============================
 Modification History
 18-09-2014  by Kim To
     Moved Matt code from plan.jsp to this new file
 

 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="fieldsetborder">
<h4 class="sixteen columns"  style="float:none;">Developed By</h4>
<article id="itDeveloper">
	<%@include file="iterPlanDevelopers.jsp" %>
</article>

<article id="artDeveloper" class="row" style="visibility: hidden; display: none;">
	<section class="secIssue sixteen columns curveBorder">
	<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<div class="row">
			<div class="fifteen columns">
				<s:select list="developerSelectList" listKey="id" listValue="fullName" name="theDeveloperList[%{#stat.index}]" headerKey="-1" headerValue="Select a Plan Developer"/>
			</div>
		</div>
	</section>
	<%-- <section class="secIssue sixteen columns curveBorder">
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<fieldset>
			<div class="row">
				<div class="eight columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" id="advocateList" headerKey="-1" headerValue="Select Developer" onChange="changeContact(this)" /></div>
				<section class="four columns"><p></p></section>
				<input type="button" id="btnAdvocateDetails" onclick="showContact(this, 'Developer Details')"  value="Show Developer Details" class="three columns omega"/>
			</div>		
			<div class="row toggled">
				<div class="three columns"><s:select list="titleSelectList.{name}" name="theTitle" id="titleContact" headerKey="-1" headerValue="Title" disabled="true"/></div>
				<div class='inputfield four columns'>
					<s:label for="firstNameContact" value="First Name:" />
					<div><s:textfield id="firstNameContact" Key="firstName" name="contact.firstname" readonly="true"></s:textfield></div>
				</div>
				<div class="inputfield four columns">
					<s:label for="otherNameContact" value="Other Name:" />
					<div><s:textfield id="otherNameContact" name="contact.othername" readonly="true"></s:textfield></div>
				</div>
				
				<div class="inputfield four columns omega">
					<s:label for="lastNameContact" value="Last Name:" />
					<div><s:textfield id="lastNameContact" name="contact.lastname" Key="lastname" readonly="true"></s:textfield></div>
				</div>
			</div>
			
			<div class="row toggled">
				<div class="three columns"><s:select list="genderSelectList.{genderName}" name="theGender" id="genderContact" headerKey="-1" headerValue="Gender" disabled="true"/></div>
				<!-- style="padding-right: 15px;" -->
				<div class="inputfield eight columns" >
					<s:label for="identificationContact" value="Identification:" />
					<div><s:textfield id="identificationContact" name="contact.identification" readonly="true"></s:textfield></div>
				</div>
				
				<div class="inputfield four columns omega ">
					<s:label for="birthDateContact" value="Birth Date:" />
					<div><input type="date" id="birthDateContact" name="contact.dob" readonly="readonly"></div>
				</div>
			</div>
			
			<div class="row toggled">
				<div class="three columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" id="culturalBackgroundContact" value="theCultrualBackground" headerKey="-1"  headerValue="Cultural Background" value="genderProtege"  disabled="true"/></div>
				
				<div class="textarea twelve columns omega">
					<s:label for="culturalBackgroundCommentsContact" value="Comments:" />
					<div><s:textarea id="culturalBackgroundCommentsContact" cssClass="oneLineTextArea" name="contact.culturalBackgroundComment" readonly="true"></s:textarea></div> 
				</div>
			</div>
			
			<div class="row toggled">
				<div class="inputfield five columns">
					<s:label for="emailContact" value="Email:" />
					<div><s:textfield id="emailContact" name="contact.email" readonly="true"></s:textfield></div>
				</div>
				
				<div class="inputfield four columns omega">
					<s:label for="mobileContact" value="Mobile#:" />
					<div><s:textfield id="mobileContact" name="contact.mobilephone" readonly="true" ></s:textfield></div>
				</div>
			</div>
		</fieldset>
	</section> --%>
</article>
<div class="row">
	<div class="thirteen columns alpha"><p></p></div>
	<input type="button" id="btnAddDeveloper" value="Add Plan Developer" class="three columns"/>
</div>

<script>
$(function(){
	$("#btnAddDeveloper").click(function(){ 
		$("#artDeveloper section").clone().appendTo("#itDeveloper");
	});
});
</script>
</div>	