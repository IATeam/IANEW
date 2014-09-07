<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action cssClass and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Changed div to s:div and related class to cssClass Quang Nhan
						reorder syntax to be consistent throughout the jsps
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the summary details.
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>

<s:div cssClass="fieldsetborder">
	<fieldset>
		<s:div cssClass="row">
			<s:div cssClass="four columns">
				<s:select  name="iamodel.enquiryType.enquiryTypeName" cssClass="four columns" list="enquiryTypeSelectList.{enquiryTypeName}" headerKey="-1" headerValue="Type" />
			</s:div>
			<s:div cssClass="textarea twelve columns">
				<s:label for="description" value="Description:" />
				<s:div><s:textarea id="description" name="iamodel.description"  cssClass="multiLineTextArea" /></s:div>
			</s:div>
		</s:div>
	</fieldset>
</s:div>