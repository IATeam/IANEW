<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="row planPeopleDiv" id="supportPersonDiv">
	<s:hidden id="supportContactId" name="supportContactId" value="%{iamodel.plan.supportPerson.id}" />
	<div class='inputfield four columns'>
		<s:label for="firstNameContact" value="Support First Name:" />
		<div><s:textfield id="supportFirstName" name="iamodel.plan.supportPerson.firstname" ></s:textfield></div>
	</div>
	<div class="inputfield four columns">
		<s:label for="otherNameContact" value="Support Other Name:" />
		<div><s:textfield id="supportOtherName" name="iamodel.plan.supportPerson.othername"></s:textfield></div>
	</div>
				
	<div class="inputfield four columns omega">
		<s:label for="lastNameContact" value="Support Last Name:" />
		<div><s:textfield id="supportLastName" name="iamodel.plan.supportPerson.lastname"></s:textfield></div>
	</div>

	<div class="inputfield four columns omega">
		<s:label for="mobileContact" value="Support Mobile#:" />
		<div><s:textfield id="supportMobile" name="iamodel.plan.supportPerson.mobilephone" ></s:textfield></div>
	</div>
</div>