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
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the personal detail.
------------------------------------------------------------------------------------------------>
<h3 class="sixteen columns"  style="float:none;">Advocate</h3>

<div class="fieldsetborder">
	<fieldset>
		<div class="row">
			<div class="eight columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" headerKey="-1" headerValue="Select Advocate" /></div>
			<section class="five columns"><p></p></section>
			<input type="button" id="btnAdvocateDetails" onclick="showAdvocates()" value="Show Advocate Details" class="three columns omega"/>
		</div>		
		<div class="row toggled">
			<div class='inputfield four columns'>
				<s:label for="firstName" value="First Name:" />
				<div><s:textfield id="firstName" Key="firstName" name="contact.firstname" readonly="true"></s:textfield></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="otherName" value="Other Name:" />
				<div><s:textfield id="otherName" name="contact.othername" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastName" value="Last Name:" />
				<div><s:textfield id="lastName" name="contact.lastname" Key="lastname" readonly="true"></s:textfield></div>
			</div>
		</div>
		
		<div class="row toggled">
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="theGender" headerKey="-1" headerValue="Select Gender" disabled="true"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identification" value="Identification:" />
				<div><s:textfield id="identification" name="contact.identification" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDate" value="Birth Date:" />
				<div><input type="date" id="birthDate" name="contact.dob" readonly="true"></div>
			</div>
		</div>
		
		<div class="row toggled">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" value="theCultrualBackground" headerKey="-1"  headerValue="Select Cultural Background" value="genderProtege"  disabled="true"/></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundComments" value="Comments:" />
				<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="contact.culturalBackgroundComment" readonly="true"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row toggled">
			<div class="inputfield four columns">
				<s:label for="email" value="Email:" />
				<div><s:textfield id="email" name="contact.email" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobile" value="Mobile#:" />
				<div><s:textfield id="mobile" name="contact.mobilephone" readonly="true" ></s:textfield></div>
			</div>
		</div>
	</fieldset>
</div>