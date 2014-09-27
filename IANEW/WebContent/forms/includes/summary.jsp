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
		27/08/2014 -	Quang Nhan changed the label from description to notes as requested
						by client.
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the summary details.
	
	Note: syntax order: <tag id name class value list(for select) ...>
------------------------------------------------------------------------------------------------>
<%@taglib prefix="s" uri="/struts-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
<h3 class="sixteen columns" style="float:none;">Summary</h3>
<div class="greybackground">
	<div id="issuesDiv" class="toggled hideable">	
		<fieldset>
			<s:div cssClass="row">
				<s:div cssClass="four columns">
					<s:select tooltip="Hi" tooltipDelay="10" name="theEnquiry" cssClass="four columns" list="enquiryTypeSelectList.{enquiryTypeName}" value="iamodel.enquiryType.enquiryTypeName" headerKey="-1" headerValue="Type" />
				</s:div>
				<s:div cssClass="textarea twelve columns">
					<s:label for="description" value="Notes:" />
					<s:div><s:textarea id="description" name="iamodel.description" cssClass="multiLineTextArea" tooltip="Enter notes related to this enquiry"/></s:div>
				</s:div>
			</s:div>
		</fieldset>
	</div>
</div>
</section>
<!-- Used for tooltip purposes for enquiry type list -->
<s:div id="tooltip">
	<s:iterator value = "enquiryTypeSelectList" status="stat">
		<s:hidden name="enquiryTypeDescription"  id="%{enquiryTypeName}"/>
	</s:iterator>
</s:div>
<script>
$("select option").each(function(){
	if($(this).val() != -1)
	{
		if($("#" + $(this).val())){
			var title = $("#" + $(this).val()).val();
			 $(this).attr("title", title);
		}
	}
})
$(function(){$("[tootip]").tooltip();})


</script>
