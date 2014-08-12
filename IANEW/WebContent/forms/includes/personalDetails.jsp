<h3 class="sixteen columns"  style="float:none;">Personal Details</h3>
<div class="fieldsetborder">
	<fieldset>
	
		<div class="row">
			<div class="four columns"><s:select list="titleSelectList.{name}" value="personTitleProtege" name="theTitle" headerKey="-1" headerValue="Select Title" /></div>
	
			<div class='inputfield four columns'>
				<s:label for="firstName" value="First Name:" />
				<div><s:textfield id="firstName" Key="firstName" name="firstName"></s:textfield></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="otherName" value="Other Name:" />
				<div><s:textfield id="otherName" name="otherName"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastName" value="Last Name:" />
				<div><s:textfield id="lastName" name="lastName" Key="lastName"></s:textfield></div>
			</div>
		</div>
		
		<div class="row">
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="theGender" headerKey="-1" headerValue="Select Gender"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identification" value="Identification:" />
				<div><s:textfield id="identification" name="identification"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDate" value="Birth Date:" />
				<div><input type="date" id="birthDate" name="birthDate"></div>
			</div>
		</div>
		
		<div class="row">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" headerKey="-1"  headerValue="Select Cultural Background" value="genderProtege" /></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundComments" value="Comments:" />
				<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="culturalBackgroundComments"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row">
			<div class="inputfield four columns">
				<s:label for="email" value="Email:" />
				<div><s:textfield id="email" name="email"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobile" value="Mobile#:" />
				<div><s:textfield id="mobile" name="mobile" ></s:textfield></div>
			</div>
		</div>
	</fieldset>
</div>