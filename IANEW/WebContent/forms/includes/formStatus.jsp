<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	
		14/08/2014 	- 	Connect and retrieve data called by the action class 
		18/08/2014 -	Quang Nhan
						Changed date format display to dd MMM yyyy
		25/08/2014 -	Quang Nhan
						Connect status to action class.
		27/08/2014 -	Removed all enquiry to form wording to standardize to 
						allow case to be used as well.
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the form status detail.
------------------------------------------------------------------------------------------------>

<div class="formStatus">
	
		<div class="row">
			<div class="six columns">
				<s:label for="createdDate" value="Created Date:" />
			    <s:date name="iamodel.createdDateTime" format="dd MMM yyyy"/>
			   
				<s:label for="lastUpdatedOn" value="Last Updated On:" />
				<s:date name="iamodel.updatedDateTime" format="dd MMM yyyy"/>
				<br>
				<s:label for="createdBy" value="Created By:" />
				
				<s:label for="iamodel.lastUpdatedBy" value="Last Updated By:" />
				
				<!-- <s:text id="lastUpdatedBy" name="" /> -->
			</div>
			<div class="nine columns">
				<div class="row">
			
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" name="iamodel.contact.dangerType.dangerName" headerKey="-1" headerValue="Flag Danger" /></div>
					<div class="three columns"><s:select id="theStatus" list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Form Status" /></div>
					<s:div cssClass="two columns">
						<s:label for="id" value="Enquiry#:" />
						<s:property value="iamodel.id" />
					</s:div>
				</div>
			</div>
		</div>
		<s:hidden name="iamodel.createdDateTime"/>
		<s:hidden name="iamodel.updatedDateTime"/>
</div>
