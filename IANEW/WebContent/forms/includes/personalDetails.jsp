<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		12/08/2014 - 	Quang Nhan
						Migrate code into new project setup
		14/08/2014 - 	Quang Nhan
						Connect and retrieve data called by the action class and added pagination functionality
		16/08/2014 -	Quang Nhan
						Changed s:div to s:s:div and related class to cssClass
						reorder syntax to be consistent throughout the jsps
		07/08/2014 -	Quang Nhan
						Added autocomplete feature
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the personal detail.
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<input type="button" id="contactSearch" /><h3 class="sixteen columns"  style="float:none;">Personal Details</h3>
<div class="fieldsetborder">
	<fieldset>
		<s:hidden name="ccontact.id" />
		<div class="row">
			<div class="four columns"><s:select list="titleSelectList.{name}" name="ccontact.titleType.name" headerKey="-1" headerValue="Select Title" /></div>
	
			<div class='inputfield four columns'>
				<s:label for="firstName" value="First Name:" />
				<div><sj:autocompleter placeholder="enter first name" id="firstName" name="ccontact.firstname" list="%{firstNameAuto}" /></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="otherName" value="Other Name:" />
				<div><s:textfield id="otherName" name="ccontact.othername" /></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastName" value="Last Name:" />
				<div><s:textfield id="lastName" name="ccontact.lastname" /></div>
			</div>
		</div>
		<!-- name="ccontact.genderType.genderName" -->
		<div class="row">
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="ccontact.genderType.genderName" headerKey="-1" headerValue="Select Gender"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identification" value="Identification:" />
				<div><s:textfield id="identification" name="ccontact.identification"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDate" value="Birth Date:" />
				<div><input type="date" id="birthDate" name="dob" value="<s:property value='ccontact.dob.toString()'/>" /></div>
			</div>
		</div>
		
		<div class="row">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="ccontact.culturalBackground.culturalBackgroundName" headerKey="-1"  headerValue="Select Cultural Background" /></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundComments" value="Comments:" />
				<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="ccontact.culturalBackgroundComment"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="email" value="Email:" />
				<div><s:textfield id="email" name="ccontact.email"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobile" value="Mobile#:" />
				<div><s:textfield id="mobile" name="ccontact.mobilephone" ></s:textfield></div>
			</div>
		</div>
	</fieldset>
	<script>
		
	</script>
</div>