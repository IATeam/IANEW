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
function changeAdvocate(selectList) {
		var selectedAdvocate = $(selectList).val();
		if (selectedAdvocate == -1)
		{
			$("#titleAdvocate").val("-1");
			 $("#firstNameAdvocate").val("");
			 $("#otherNameAdvocate").val("");
			 $("#lastNameAdvocate").val("");
			 $("#genderAdvocate").val("-1");
			 $("#birthDateAdvocate").val("");
			 $("#identificationAdvocate").val("");
			 $("#culturalBackgroundAdvocate").val("-1");
			 $("#culturalBackgroundCommentsAdvocate").val("");
			 $("#emailAdvocate").val("");
			 $("#mobileAdvocate").val("");
		}
		
	    <s:iterator var="advocate" value="advocateSelectList">
	    	var fullname = "<s:property value='#advocate.lastname'/>" + ", " + "<s:property value='#advocate.firstname'/>"
	    	if(selectedAdvocate == fullname)
	    	{
	    	    <s:iterator var="title" value="titleSelectList">
		    		if("<s:property value='#advocate.titleType.name'/>" == "<s:property value='#title.name'/>")
		    		{
						 $("#titleAdvocate").val("<s:property value='#title.name'/>");
		    		}
	    	    </s:iterator>
				$("#firstNameAdvocate").val("<s:property value='#advocate.firstname'/>");
				$("#otherNameAdvocate").val("<s:property value='#advocate.othername'/>");
				$("#lastNameAdvocate").val("<s:property value='#advocate.lastname'/>");
				<s:iterator var="gender" value="genderSelectList">
		    		if("<s:property value='#advocate.genderType.genderName'/>" == "<s:property value='#gender.genderName'/>")
		    		{
						 $("#genderAdvocate").val("<s:property value='#gender.genderName'/>");
		    		}
    	    	</s:iterator>
   				$("#identificationAdvocate").val("<s:property value='#advocate.identification'/>");
   				<s:iterator var="culturalBackground" value="culturalBackgroundSelectList">
	    		if("<s:property value='#advocate.culturalBackground.culturalBackgroundName'/>" == "<s:property value='#culturalBackground.culturalBackgroundName'/>")
	    		{
					 $("#culturalBackgroundAdvocate").val("<s:property value='#culturalBackground.culturalBackgroundName'/>");
	    		}
	    		</s:iterator>
				$("#culturalBackgroundCommentsAdvocate").val("<s:property value='#advocate.culturalBackgroundComment'/>");
				$("#emailAdvocate").val("<s:property value='#advocate.email'/>");
				$("#mobileAdvocate").val("<s:property value='#advocate.mobilephone'/>");

	    	}
	    </s:iterator>
}
</script>

<h3 class="sixteen columns"  style="float:none;">Advocate</h3>
<div class="fieldsetborder">
	<fieldset>
		<div class="row">
			<div class="eight columns"><s:select list="advocateSelectList.{lastname + ', ' + firstname}" name="theAdvocate" id="advocateList" headerKey="-1" headerValue="Select Advocate" onChange="changeAdvocate(this)" /></div>
			<section class="five columns"><p></p></section>
			<input type="button" id="btnAdvocateDetails" onclick="showAdvocates()" value="Show Advocate Details" class="three columns omega"/>
		</div>		
		<div class="row toggled">
			<div class="four columns"><s:select list="titleSelectList.{name}" name="theTitle" id="titleAdvocate" headerKey="-1" headerValue="Title" disabled="true"/></div>
			<div class='inputfield four columns'>
				<s:label for="firstNameAdvocate" value="First Name:" />
				<div><s:textfield id="firstNameAdvocate" Key="firstName" name="contact.firstname" readonly="true"></s:textfield></div>
			</div>
			<div class="inputfield four columns">
				<s:label for="otherNameAdvocate" value="Other Name:" />
				<div><s:textfield id="otherNameAdvocate" name="contact.othername" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="lastNameAdvocate" value="Last Name:" />
				<div><s:textfield id="lastNameAdvocate" name="contact.lastname" Key="lastname" readonly="true"></s:textfield></div>
			</div>
		</div>
		
		<div class="row toggled">
			<div class="four columns"><s:select list="genderSelectList.{genderName}" name="theGender" id="genderAdvocate" headerKey="-1" headerValue="Gender" disabled="true"/></div>
			<!-- style="padding-right: 15px;" -->
			<div class="inputfield eight columns" >
				<s:label for="identificationAdvocate" value="Identification:" />
				<div><s:textfield id="identificationAdvocate" name="contact.identification" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega ">
				<s:label for="birthDateAdvocate" value="Birth Date:" />
				<div><input type="date" id="birthDateAdvocate" name="contact.dob" readonly="true"></div>
			</div>
		</div>
		
		<div class="row toggled">
			<div class="four columns"><s:select list="culturalBackgroundSelectList.{culturalBackgroundName}" name="theCulturalBackground" id="culturalBackgroundAdvocate" value="theCultrualBackground" headerKey="-1"  headerValue="Cultural Background" value="genderProtege"  disabled="true"/></div>
			
			<div class="textarea twelve columns omega">
				<s:label for="culturalBackgroundCommentsAdvocate" value="Comments:" />
				<div><s:textarea id="culturalBackgroundCommentsAdvocate" cssClass="oneLineTextArea" name="contact.culturalBackgroundComment" readonly="true"></s:textarea></div> 
			</div>
		</div>
		
		<div class="row toggled">
			<div class="inputfield five columns">
				<s:label for="emailAdvocate" value="Email:" />
				<div><s:textfield id="emailAdvocate" name="contact.email" readonly="true"></s:textfield></div>
			</div>
			
			<div class="inputfield four columns omega">
				<s:label for="mobileAdvocate" value="Mobile#:" />
				<div><s:textfield id="mobileAdvocate" name="contact.mobilephone" readonly="true" ></s:textfield></div>
			</div>
		</div>
	</fieldset>
</div>