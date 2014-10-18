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
		29/09/2014 -	Quang Nhan modified select list to accommodate value by id rather than name
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the personal detail.
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section>
<img src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" onclick="divHide(this);return false;" class="divHideButton"/>
<s:if test="%{#formType=='case'}">
	<h3 class="sixteen columns"  style="float:none;">Client Details</h3>
</s:if>
<s:elseif test="%{#formType=='enquiry'}">
	<h3 class="sixteen columns"  style="float:none;">Personal Details</h3>
</s:elseif>
<img src="/IANEW/resources/images/srchicon.png" onclick="loadContactSearchForm()" class="searchButton" >

<s:div id="contactSearchDiv" cssClass="hidden"> 
	<s:include value="search/searchContact.jsp" />
</s:div>

<div class="greybackground">
	<div id="personalDetailsDiv" class="toggled hideable">
		<fieldset>
			<s:hidden name="iamodel.contact.id" />
			<div class="row">
				<div class="four columns"><s:select list="titleSelectList" listKey="id" listValue="name" name="theTitleTypeId" headerKey="-1" headerValue="Select Title" /></div>
		
				<div class='inputfield four columns'>
					<s:label for="firstname" value="First Name:" />
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
			<div class="row">
				<div class="four columns"><s:select list="genderSelectList" listKey="id" listValue="genderName" name="theGenderTypeId" headerKey="-1" headerValue="Select Gender"/></div>
				<!-- style="padding-right: 15px;" -->
				<div class="inputfield eight columns" >
					<s:label for="identification" value="Identification:" />
					<div><s:textfield id="identification" name="iamodel.contact.identification" /></div>
				</div>
				
				<div class="inputfield four columns omega ">
					<s:label for="birthDate" value="Birth Date:" />
					<div><input type="date" id="birthDate" name="dob" value="<s:property value='iamodel.contact.dob.toString()'/>" /></div>
				</div>
			</div>
			
			<div class="row">
				<div class="four columns"><s:select list="culturalBackgroundSelectList" listKey="id" listValue="culturalBackgroundName" name="theCulturalBackgroundTypeId" headerKey="-1"  headerValue="Select Cultural Background" /></div>
				
				<div class="textarea twelve columns omega">
					<s:label for="culturalBackgroundComments" value="Comments:" />
					<div><s:textarea id="culturalBackgroundComments" cssClass="oneLineTextArea" name="iamodel.contact.culturalBackgroundComment"></s:textarea></div> 
				</div>
			</div>
			
			<div class="row">
				<div class="inputfield four columns">
					<s:label for="email" value="Email:" />
					<div><s:textfield id="email" name="iamodel.contact.email" /></div>
				</div>
				
				<div class="inputfield four columns omega">
					<s:label for="mobile" value="Mobile#:" />
					<div><s:textfield id="mobile" name="iamodel.contact.mobilephone" /></div>
				</div>
			</div>
		</fieldset>
	</div>
</div>
</section>
<script>
function loadContactSearchForm(){
	
	
	//$("#contactsSearchDiv").load("contactList/loadClientSearchForm.action");
	//$('body').addClass('sepia');
	//$('#contactSearchDiv').css({'filter':'none', '-webkit-filter':'none'});
	//$("#divRadio").hide();
	//$("#secSearch").hide();
	//$("#secSearch").prependTo("#secContactSearchBar");
	//$("#divSearchContactOptions").appendTo("#secSearch");
	$("#contactSearchDiv").removeClass("hidden");
	//$("#secSearch").show("slow");
	//$("#searchbox").val("firtname:    lastname: ");
	
}
	
</script>
