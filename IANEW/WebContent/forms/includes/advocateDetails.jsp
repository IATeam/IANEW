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
<script>
function changeContact(selectedPerson) {
	var selectedContact = $(selectedPerson).val();
	var pathA = $(selectedPerson).parent("div").parent("div").parent("fieldset").children("div").children("div").children("div");
	if (selectedContact == -1)
	{
		 $(pathA).children("#titleContact").val("-1");
		 $(pathA).children("#firstNameContact").val("");
		 $(pathA).children("#otherNameContact").val("");
		 $(pathA).children("#lastNameContact").val("");
		 $(pathA).children("#genderContact").val("-1");
		 $(pathA).children("#birthDateContact").val("");
		 $(pathA).children("#identificationContact").val("");
		 $(pathA).children("#culturalBackgroundContact").val("-1");
		 $(pathA).children("#culturalBackgroundCommentsContact").val("");
		 $(pathA).children("#emailContact").val("");
		 $(pathA).children("#mobileContact").val("");
	}
	
    <s:iterator var="contact" value="advocateSelectList">
    	var fullname = "<s:property value='#contact.lastname'/>" + ", " + "<s:property value='#contact.firstname'/>"
    	if(selectedContact == fullname)
    	{
    	    <s:iterator var="title" value="titleSelectList">
	    		if("<s:property value='#contact.titleType.name'/>" == "<s:property value='#title.name'/>")
	    		{
	    			$(pathA).children("#titleContact").val("<s:property value='#title.name'/>");
	    		}
    	    </s:iterator>
    	    $(pathA).children("#firstNameContact").val("<s:property value='#contact.firstname'/>");
    	    $(pathA).children("#otherNameContact").val("<s:property value='#contact.othername'/>");
    	    $(pathA).children("#lastNameContact").val("<s:property value='#contact.lastname'/>");
			<s:iterator var="gender" value="genderSelectList">
	    		if("<s:property value='#contact.genderType.genderName'/>" == "<s:property value='#gender.genderName'/>")
	    		{
	    			$(pathA).children("#genderContact").val("<s:property value='#gender.genderName'/>");
	    		}
	    	</s:iterator>
	    	$(pathA).children("#birthDateContact").val("<s:property value='#contact.getDateString()'/>");
	    	$(pathA).children("#identificationContact").val("<s:property value='#contact.identification'/>");
				<s:iterator var="culturalBackground" value="culturalBackgroundSelectList">
    		if("<s:property value='#contact.culturalBackground.culturalBackgroundName'/>" == "<s:property value='#culturalBackground.culturalBackgroundName'/>")
    		{
    			$(pathA).children("#culturalBackgroundContact").val("<s:property value='#culturalBackground.culturalBackgroundName'/>");
    		}
    		</s:iterator>
    		$(pathA).children("#culturalBackgroundCommentsContact").val("<s:property value='#contact.culturalBackgroundComment'/>");
    		$(pathA).children("#emailContact").val("<s:property value='#contact.email'/>");
    		$(pathA).children("#mobileContact").val("<s:property value='#contact.mobilephone'/>");

    	}
    </s:iterator>
}
</script>
<section>
<h3 class="sixteen columns"  style="float:none;">Advocate</h3>
<input type="image" src="/IANEW/resources/images/minusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<div class="fieldsetborder">
<div id="advocateDetailsDiv" class="toggled startShown">	
	<fieldset>
		<div class="row">
			<div class="eight columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" id="advocateList" headerKey="-1" headerValue="Select Advocate" onChange="changeContact(this)" /></div>
			<section class="five columns"><p></p></section>
			<input type="button" id="btnAdvocateDetails" onclick="showContact(this, 'Advocate Details')" value="Show Advocate Details" class="three columns omega"/>
		</div>		
		<div class="row toggled">
			<div class="four columns"><s:select list="titleSelectList.{name}" name="theTitle" id="titleContact" headerKey="-1" headerValue="Title" disabled="true"/></div>
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
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="theGender" id="genderContact" headerKey="-1" headerValue="Gender" disabled="true"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identificationContact" value="Identification:" />
				<div><s:textfield id="identificationContact" name="contact.identification" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDateContact" value="Birth Date:" />
				<div><input type="date" id="birthDateContact" name="contact.dob" readonly="true"></div>
			</div>
		</div>
		
		<div class="row toggled">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" id="culturalBackgroundContact" value="theCultrualBackground" headerKey="-1"  headerValue="Cultural Background" value="genderProtege"  disabled="true"/></div>
			
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
</div>
</div>
</section>