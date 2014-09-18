<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="iamodel.communicationsList" status="stat">		
	<section class="secIssue sixteen columns curveBorder">
		<s:hidden name="iamodel.communicationsList[%{#stat.index}].id"/>
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="return false;" class="undoButton"/>
			<div class="row">
				<div class="three columns">
					<s:select list="communicationSelectList.{communicationTypeName}" name="theCommunicationsList" headerKey="-1" headerValue="Select Communication Type" />
				</div>
			<div class="three columns">
				<s:label for="createdDate" value="Created Date:" />
			    <s:date name="iamodel.communicationsList[%{#stat.index}].createdDateTime" format="dd/MM/yyyy"/>
		    </div>
		    <div class="three columns">
				<s:label for="createdBy" value="Created By:" />
			    <s:date name="iamodel.communicationsList[%{#stat.index}].createdUserId" format="dd/MM/yyyy"/>
		    </div>
		    <div class="inputfield four columns omega">
				<s:label for="communicationDate" value="Commun. Date:" />
				<div><input type="date" name="communicationDate" id="communicationDate" value="<s:property value='iamodel.communicationsList[%{#stat.index}].communicationDate'/>" /></div>
			</div>
			<div class="inputfield two columns omega">
			    <s:label for="timespent" value="Time Spent:" />
				<div><input type="text" name="iamodel.communicationsList[%{#stat.index}].timeSpent"></div>
			</div>
			<div class="row">
				<div class="textarea fourteen columns omega">
				<s:label for="comments" value="Comments:" />
				<s:textarea cssClass="oneLineTextArea" name="iamodel.communicationsList[%{#stat.index}].description"/> 
				</div>
				<input type="button" id="btnImportant" class="one columns" onclick="importantDiv(this)"/>
			</div>
		</section>
</s:iterator>