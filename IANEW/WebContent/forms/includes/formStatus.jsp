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
<script>
function changeDangerColour(selectList) {
		var selectedDanger = $(selectList).val();
		
		if (selectedDanger == -1)
		{
			 $(selectList).css({'background':'grey'});
		}
		
	    <s:iterator value="dangerSelectList">
	    	if(selectedDanger == "<s:property value='dangerName'/>")
	    	{
	    		$(selectList).css({"background": "<s:property value='symbol'/>"});
	    	}
	    </s:iterator>
}

function changePriorityColour(selectList) {
	var selectedPriority = $(selectList).val();
	
	if (selectedPriority == -1)
	{
		 $(selectList).css({'background':'grey'});
	}
	
    <s:iterator value="prioritySelectList">
    	if(selectedPriority == "<s:property value='priorityName'/>")
    	{
    		$(selectList).css({"background": "<s:property value='color'/>"});
    	}
    </s:iterator>
}
</script>

<div class="formStatus">
	<div class="four columns">
		<s:label for="createdDate" value="Created Date:" />
	    <s:date name="createdDate" format="dd MMM yyyy"/>
   	</div>						
	    
	<div class="four columns">
		<s:label for="lastUpdatedOn" value="Last Updated On:" />
		<s:date name="updatedDate" format="dd MMM yyyy"/>
	</div>
	
	<div class="three columns">
		<s:select list="dangerSelectList.{dangerName}" name="theDanger" headerKey="-1" headerValue="Flag Danger" cssClass="coloured" onChange="changeDangerColour(this)"/>
	</div>
	
	<s:if test="%{#formType=='case'}">
		<div class="two columns">
			<s:select id="status" list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Case Status" />
		</div>
		
		<s:div cssClass="two columns">
			<s:label for="id" value="Case#:" />
			<s:property value="id" />
		</s:div>
	</s:if>					
	<s:elseif test="%{#formType=='enquiry'}">
		<div class="two columns">
			<s:select id="status" list="statusSelectList.{statusName}" name="theStatus" headerKey="-1" headerValue="Enquiry Status" />
		</div>
		
		<s:div cssClass="two columns">
			<s:label for="id" value="Enquiry#:" />
			<s:property value="id" />
		</s:div>
	</s:elseif>				
	<div class="four columns">
		<s:label for="createdBy" value="Created By:" />
		<s:property value="createdBy"/>
	</div>					
	<div class="four columns">	
		<s:label for="lastUpdatedBy" value="Last Updated By:" />
		<s:property value="updatedBy"/>
	</div>			
	<s:if test="%{#formType=='case'}">
		<div class="four columns">
			<s:select list="prioritySelectList.{priorityName}" name="thePriority" headerKey="-1" headerValue="Priority Level" cssClass="coloured" onChange="changePriorityColour(this)"/>
		</div>
	</s:if>				
</div>