<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<div class="row planPeopleDiv" id="authorisedPersonDiv">
	<s:hidden name="authorisedContactId" value="%{iamodel.plan.authorisedBy.id}" />
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