<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/09/2014
	==============================================
	Updates:
	==============================================	
	Description: A jsp page that displays iterator for address
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:iterator value="linkedEnquiriesList" status="stat">
	<section class="secLinkedEnquiries sixteen columns curveBorder"  onclick="bandSelected(this)">
		<s:div cssClass="textarea one columns">
			<s:label value="E#:" />
			<s:div cssClass="id"><s:property  value="id"/></s:div>
		</s:div>
		<s:div cssClass="textarea three columns">
			<s:label for="date" value="Date:" />
			<!-- <s:property value="updatedDateTime"/> -->
			<s:date name="updatedDateTime" format="dd MMM yyyy"/>
		</s:div>
		<div class="textarea eleven columns omega">
			<s:label for="description" value="Description:" />
			<div><s:textarea id="description" cssClass="multiLineTextArea" name="description" readonly="true"/></div>
		</div>
	</section>
</s:iterator>