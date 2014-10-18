<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">Personal Details</h3>
		<div class="greybackground">
		<div id="personalDetailsDiv" class="toggled hideable">
	<fieldset>
		<s:hidden name="contact.id" />
		<div class="row">
			<div class="four columns"><s:select list="titleSelectList" listKey="id" listValue="name" name="theTitleTypeId" headerKey="-1" headerValue="Select Title" /></div>
	
			<div class='inputfield four columns'>
				<s:label for="firstname" value="First Name:" />
				<div><s:textfield id="firstname" name="contact.firstname" /></div>
				<!-- <sj:autocompleter placeholder="enter first name" id="firstName" name="iamodel.contact.firstname" list="%{firstNameAuto}" /> -->
			</div>
			<div class="inputfield four columns">
				<s:label for="otherName" value="Other Name:" />
				<div><s:textfield id="otherName" name="contact.othername" /></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastName" value="Last Name:" />
				<div><s:textfield id="lastName" name="contact.lastname"   /></div> 
				
			</div>
		</div>
		<div class="row">
			<div class="four columns"><s:select list="genderSelectList" listKey="id" listValue="genderName" name="theGenderTypeId" headerKey="-1" headerValue="Select Gender"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identification" value="Identification:" />
				<div><s:textfield id="identification" name="contact.identification" /></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDate" value="Birth Date:" />
				<div><input type="date" id="birthDate" name="dob" value="<s:property value='contact.dob.toString()'/>" /></div>
			</div>
		</div>
		
		<div class="row">
			<div class="four columns"><s:select list="culturalBackgroundSelectList" listKey="id" listValue="culturalBackgroundName" name="theCulturalBackgroundTypeId" headerKey="-1"  headerValue="Select Cultural Background" /></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundComments" value="Comments:" />
				<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="contact.culturalBackgroundComment"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="email" value="Email:" />
				<div><s:textfield id="email" name="contact.email" /></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobile" value="Mobile#:" />
				<div><s:textfield id="mobile" name="contact.mobilephone" /></div>
			</div>
		</div>
	</fieldset>
</div>
</div>
</section>