<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
<<<<<<< HEAD
		10/08/2014 - 	
		14/08/2014 	- 	Connect and retrieve data called by the action class 
						 
						
		18/08/2014 -	Quang Nhan
						Changed date format display to dd MMM yyyy
=======
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
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
				<div class="row">
				
				
				
				
				
				<!-- TO DO: value to fall on default if existing drop down selection -->
				
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" name="theDanger" headerKey="-1" headerValue="Flag Danger" /></div>
					<div class="three columns"><s:select id="enquiryStatus" list="#{'1':'closed' }"  value="1" headerKey="-1" headerValue="Enquiry Status" /></div>
					<s:div cssClass="two columns">
						<s:label for="id" value="Enquiry#:" />
						<s:property value="id" />
					</s:div>
				</div>
			</div>
		</div>
</div>
