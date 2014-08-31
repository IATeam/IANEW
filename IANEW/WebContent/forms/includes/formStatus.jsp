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
						Connect enquiry status to action class.
	==============================================	
	Description: A component of the contact that is to be displayed on both enquiry and case forms that 
				displays the form status detail.
------------------------------------------------------------------------------------------------>

<div class="formStatus">
	
		<div class="row">
			<div class="six columns">
				<s:label for="createdDate" value="Created Date:" />
			    <s:date name="createdDate" format="dd MMM yyyy"/>
			   <!--  <input type="date" name="createdDate" value="createdDate"/> -->
			   
				<s:label for="lastUpdatedOn" value="Last Updated On:" />
				<s:date name="updatedDate" format="dd MMM yyyy"/>
				<br>
				<s:label for="createdBy" value="Created By:" />
				<s:property value=""/>
				<!-- <s:text id="createdBy" name="" /> -->
				
				<s:label for="lastUpdatedBy" value="Last Updated By:" />
				<s:property value=""/>
				<!-- <s:text id="lastUpdatedBy" name="" /> -->
			</div>
			<div class="nine columns">
			
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" name="theDanger" headerKey="-1" headerValue="Flag Danger" cssClass="coloured" onChange="dangerChange(this)"/></div>
					<s:if test="%{#formType=='case'}">
						<div class="three columns"><s:select id="status" list="statusSelectList.{statusName}" name="theCaseStatus" headerKey="-1" headerValue="Case Status" /></div>
						<s:div cssClass="two columns">
							<s:label for="id" value="Case#:" />
							<s:property value="id" />
						</s:div>
						<div class="three columns"><s:select list="dangerSelectList.{dangerName}" name="theDanger" headerKey="-1" headerValue="Priority Level" cssClass="coloured"/></div>
						
					</s:if>					
					<s:elseif test="%{#formType=='enquiry'}">
						<div class="three columns"><s:select id="status" list="statusSelectList.{statusName}" name="theEnquiryStatus" headerKey="-1" headerValue="Enquiry Status" /></div>
						<s:div cssClass="two columns">
							<s:label for="id" value="Enquiry#:" />
							<s:property value="id" />
						</s:div>
					</s:elseif>				
				</div>
		</div>
</div>
