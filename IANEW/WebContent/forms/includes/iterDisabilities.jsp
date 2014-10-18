<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/09/2014
	==============================================
	Updates:
		29/08/2014 -	Quang Nhan added img delete button
						Modified select list to accommodate value by id rather than name
	==============================================	
	Description: A jsp page that displays iterator for client's disabilities
	
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.contact.disabilitiesList" status="stat">
	<section class="sixteen columns curveBorder row">
		<img src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" onclick="undoButton(this);" class="undoButton"/>
		<s:hidden name="iamodel.contact.disabilitiesList[%{#stat.index}].id"/>
		<s:hidden name="iamodel.contact.disabilitiesList[%{#stat.index}].primaryFlag"/>
		<s:div cssClass="four columns alpha">
			<s:div cssClass="disabilityTypeSelect row four columns">
				<s:select list="disabilitySelectList" listKey="id" listValue="disabilityName" name="theDisabilityListId[%{#stat.index}]" headerKey="-1" headerValue="Select Disability" />
			</s:div>
			<s:div cssClass="row four columns" style="text-align: center">
				<input type="radio" name="primary" onclick="primaryUpdate(this)"/>
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
