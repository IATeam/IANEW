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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<section>
<div class="formStatus"  style="padding-top:10px;margin-top:1px;">
	<div class="four columns">
		<s:label for="iamodel.createdDateTime" value="Created Date:" />
	    <s:date name="iamodel.createdDateTime" format="dd MMM yyyy"/>
   	</div>						
	    
	<div class="four columns">
		<s:label for="iamodel.updatedDateTime" value="Last Updated On:" />
		<s:date name="iamodel.updatedDateTime" format="dd MMM yyyy"/>
	</div>
	
	<div id="divDanger" class="three columns">
		<%@include file="dangerType.jsp" %>
	</div>
	
	<s:if test="%{#formType=='case'}">
		<div class="two columns">
			<s:textfield id="iamodel.healthIssueComment" name="" cssClass="colouredRed" />		
		</div>
		
		<s:div cssClass="two columns">
			<s:label for="iamodel.id" value="Case#:" cssStyle="padding-left:20px;"/>
			<s:text name="fileNumber" />
		</s:div>
	</s:if>					
	<s:elseif test="%{#formType=='enquiry'}">
		<div class="two columns">
			<s:textfield id="iamodel.healthIssueComment" name="" cssClass="colouredRed" />		
		</div>
		
		<s:div cssClass="two columns">
			<s:label for="iamodel.id" value="Enquiry#:" cssStyle="padding-left:20px;" />
			<s:property value="iamodel.id" />
		</s:div>
	</s:elseif>				
	<div class="four columns">
		<s:label for="createdBy" value="Created By:" />
		<s:property value="createdBy"/>
	</div>		
	<s:if test="%{#formType=='case'}">			
		<div class="four columns">	
			<s:label for="iamodel.lastUpdatedBy" value="Last Updated By:" />
			<s:property value="iamodel.lastUpdatedBy"/>
		</div>			
		<div class="three columns">
			<s:select list="prioritySelectList" listKey="id" listValue="priorityName" name="thePriority" headerKey="-1" headerValue="Priority Level" cssClass="coloured" cssStyle="background: %{iamodel.priorityType.color}" onChange="changePriorityColour(this)"/>
		</div>
		<div class="two columns">
			<s:select id="status" list="statusSelectList" listValue="statusName" listKey="id" name="theStatus" headerKey="-1" headerValue="Case Status" />
		</div>
	</s:if>		
	<s:elseif test="%{#formType=='enquiry'}">
		<div class="four columns">	
			<s:label for="iamodel.lastUpdatedBy" value="Last Updated By:" />
			<s:property value="iamodel.lastUpdatedBy"/>
		</div>			
		<div class="two columns">
			<s:select id="status" list="statusSelectList" listValue="statusName" listKey="id" name="theStatusTypeId" headerKey="-1" headerValue="Enquiry Status" />
		</div>
	</s:elseif>			
</div>
</section>
