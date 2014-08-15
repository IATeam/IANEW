<div class="formStatus">
	
		<div class="row">
			<div class="six columns">
				<s:label for="createdDate" value="Created Date:" />
			    <s:date name="createdDate" format="dd/MM/yyyy"/>
			   <!--  <input type="date" name="createdDate" value="createdDate"/> -->
			   
				<s:label for="lastUpdatedOn" value="Last Updated On:" />
				<s:date name="updatedDate" format="dd/MM/yyyy"/>
				<br>
				<s:label for="createdBy" value="Created By:" />
				<s:text id="createdBy" name="" />
				
				<s:label for="lastUpdatedBy" value="Last Updated By:" />
				<s:text id="lastUpdatedBy" name="" />
			</div>
			<div class="nine columns">
				<div class="row">
				
				
				
				
				
				<!-- TO DO: value to fall on default if existing drop down selection -->
				
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" value="dangerName" name="theDanger" headerKey="-1" headerValue="Flag Danger" /></div>
					<div class="three columns"><s:select list="dangerSelectList.{dangerName}" value="dangerName" name="theDanger" headerKey="-1" headerValue="Enquiry Status" /></div>
					<s:div cssClass="two columns">
						<s:label for="id" value="Enquiry#:" />
						<s:property value="id" />
					</s:div>
				</div>
			</div>
		</div>
</div>
