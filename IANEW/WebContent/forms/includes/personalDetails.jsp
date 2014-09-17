
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
		08/09/2014 -	Quang Nhan
						changed all ccontact to iamodel.contact
		15/09/2014 -	Quang Changed back all name in select list to the...
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the personal detail.
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<input type="button" id="contactSearch" /><h3 class="sixteen columns"  style="float:none;">Personal Details</h3>
<div class="fieldsetborder">
	<fieldset>
		<s:hidden name="iamodel.contact.id" />
		<div class="row">
			<div class="four columns"><s:select list="titleSelectList.{name}" name="theTitle" headerKey="-1" headerValue="Select Title" /></div>
	
			<div class='inputfield four columns'>
				<s:label for="firstName" value="First Name:" />
				<div><s:textfield id="firstname" name="iamodel.contact.firstname" /></div>
				<!-- <sj:autocompleter placeholder="enter first name" id="firstName" name="iamodel.contact.firstname" list="%{firstNameAuto}" /> -->
			</div>
			<div class="inputfield four columns">
				<s:label for="otherName" value="Other Name:" />
				<div><s:textfield id="otherName" name="iamodel.contact.othername" /></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastName" value="Last Name:" />
				<div><s:textfield id="lastName" name="iamodel.contact.lastname"   /></div> 
				
			</div>
		</div>
		<!-- name="iamodel.contact.genderType.genderName" -->
		<div class="row">
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="theGender" headerKey="-1" headerValue="Select Gender"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identification" value="Identification:" />
				<div><s:textfield id="identification" name="iamodel.contact.identification"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDate" value="Birth Date:" />
				<div><input type="date" id="birthDate" name="dob" value="<s:property value='iamodel.contact.dob.toString()'/>" /></div>
			</div>
		</div>
		
		<div class="row">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" headerKey="-1"  headerValue="Select Cultural Background" /></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundComments" value="Comments:" />
				<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="iamodel.contact.culturalBackgroundComment"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="email" value="Email:" />
				<div><s:textfield id="email" name="iamodel.contact.email"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobile" value="Mobile#:" />
				<div><s:textfield id="mobile" name="iamodel.contact.mobilephone" ></s:textfield></div>
			</div>
		</div>
	</fieldset>
	<script>
		
	</script>
</div>