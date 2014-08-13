<div class="formStatus">
	
		<div class="row">
			<div class="six columns">
				<s:label for="createdDate" value="Created Date:" />
				<s:text id="createdDate" name="" />
			      	
				<s:label for="lastUpdatedOn" value="Last Updated On:" />
				<s:text id="lastUpdatedOn" name="" />
				<br>
				<s:label for="createdBy" value="Created By:" />
				<s:text id="createdBy" name="" />
				
				<s:label for="lastUpdatedBy" value="Last Updated By:" />
				<s:text id="lastUpdatedBy" name="" />
			</div>
			<div class="nine columns">
				<div class="row">
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" value="dangerName" name="theDanger" headerKey="-1" headerValue="Flag Danger" /></div>
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" value="dangerName" name="theDanger" headerKey="-1" headerValue="Enquiry Status" /></div>
					<s:div cssClass="two columns">
						<s:label for="enquiryID" value="Case#:" />
						<s:text id="enquiryID" name="" />
					</s:div>
				</div>
			</div>
		</div>
</div>
