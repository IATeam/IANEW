<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 16/09/2014
	==============================================
	Updates:
	==============================================	
	Description: A jsp page that displays iterator for employment
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:iterator value="iamodel.contact.employmentsList" status="stat">
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.contact.employmentsList[%{#stat.index}].id"/>
		<div class="row">
			<div class="four columns"><s:select list="employmentSelectList.{employmentName}" name="theEmployment[%{#stat.index}]" headerKey="-1" headerValue="Select Employment Type" /></div>
			<div class="inputfield four columns">
				<s:label for="iamodel.contact.employmentsList[%{#stat.index}].workphone" value="Work#:" />
				<div><s:textfield id="iamodel.contact.employmentsList[%{#stat.index}].workphone" cssClass="phone" name="iamodel.contact.employmentsList[%{#stat.index}].workphone" /></div>
			</div>
		</div>
		<div class="row">
			<div class="textarea fifteen columns">
				<s:label for="employmentComment" value="Comments:" /> 
				<div><s:textarea cssClass="multiLineTextArea" name="iamodel.contact.employmentsList[%{#stat.index}].comments" /></div>
			</div>
		</div>
		<input type="button" value="delete" onclick="deleteSection(this)"/>
	</section>
</s:iterator>