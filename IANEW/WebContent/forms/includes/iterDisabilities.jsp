<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.contact.disabilitiesList" status="stat">
	<section class="sixteen columns curveBorder row">
		<s:hidden name="iamodel.contact.disabilitiesList[%{#stat.index}].id"/>
		<s:hidden name="iamodel.contact.disabilitiesList[%{#stat.index}].primaryFlag"/>
		<s:div cssClass="four columns alpha">
			<s:div cssClass="disabilityTypeSelect row four columns">
				<s:select list="disabilitySelectList.{disabilityName}" name="theDisabilityList[%{#stat.index}]" headerKey="-1" headerValue="Select Disability" />
			</s:div>
			<s:div cssClass="row four columns" style="text-align: center">
				
				<input type="radio" name="primary"  onclick="primaryUpdate(this)"/>
				<s:label value="Primary Disability"/>
			</s:div>
		</s:div>
		<s:div cssClass="textarea eleven columns">
			<s:label for="disabilityDescription" value="Comment:" /> 
			<s:textarea cssClass="disabilityDescription" cssClass="oneLineTextArea" name="iamodel.contact.disabilitiesList[%{#stat.index}].comments"></s:textarea> 
		</s:div>
	</section>
</s:iterator>
<!-- Note the delete button will call the deleteSection function in ianew.form.js -->
