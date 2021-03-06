<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:iterator value="iamodel.communicationsList" status="stat">		
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.communicationsList[%{#stat.index}].id"/>
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<div class="row">
			<div class="five columns">
				<s:select list="communicationSelectList" listValue="communicationTypeName" listKey="id" name="theCommunicationsList[%{#stat.index}]" headerKey="-1" headerValue="Select Communication Type" />
			</div>
		    <div class="inputfield six columns omega">
				<s:label for="communicationDate" value="Communication Date:" />
				<div>      					
  				<s:textfield id="DateId%{#stat.index}" cssClass="DateInputClass" name="iamodel.communicationsList[%{#stat.index}].communicationDate"/> 
	 			</div>
			</div>
			<div class="inputfield four columns omega">
			    <s:label for="timespent" value="Time Spent:" />
				<div>
					<%-- <input type="text" name="iamodel.communicationsList[%{#stat.index}].timeSpent" value="<s:property value="iamodel.communicationsList[%{#stat.index}].timeSpent.toString()"/>"/> --%>
					<s:textfield name="iamodel.communicationsList[%{#stat.index}].timeSpent"  />
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="textarea fourteen columns omega">
			<s:label for="comments" value="Communication Notes:" />
			<s:textarea cssClass="oneLineTextArea" name="iamodel.communicationsList[%{#stat.index}].description"/> 
			</div>
			
			<s:hidden name="iamodel.communicationsList[%{#stat.index}].importantFlag"/>
			<input type="button" id="btnImportant" class="one columns" name="importantFlag" onclick="importantDiv(this)"/>
		</div>
	</section>
</s:iterator>