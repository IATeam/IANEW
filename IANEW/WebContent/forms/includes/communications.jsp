<!----------------------------------------------------------------------------------------------
	Created By: Quang Nhan
	Created Date: 02/08/2014
	==============================================
	Updates:
		10/08/2014 - 	Added iteration by Quang Nhan
		14/08/2014 	- 	Connect and retrieve data called by the action class and added 
						pagination functionality by Quang Nhan
<<<<<<< HEAD
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
=======
<<<<<<< HEAD
		21/08/2014 -	Quang Nhan
						Added "Add Issue" button and functionality
						
=======
		16/08/2014 -	Tested s:url workings see comment below. 
						Moved javascript code to list.js file by Quang Nhan
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Quang
	==============================================	
	Description: A jsp page that displays a list of enquiries
------------------------------------------------------------------------------------------------>
<%@ taglib prefix="s" uri="/struts-tags" %>

<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/><h3 class="fifteen columns" style="float:none;">Communications</h3>
<div class="greybackground">
<div id="communicationsDiv" class="toggled hideable">	
	<article id="itCommunication">
		<%@include file="iterCommunications.jsp" %>
	</article>
	
 	<s:if test="%{iamodel.communicationsList.size > 0}">
		<s:hidden id="communicationSize" name="iamodel.communicationsList.size" value="%{iamodel.communicationsList.size}"/>
		<s:set name="index" value="iamodel.communicationsList.size" />
		<article id="artCommunication" class="hidden">
	</s:if>
	<s:else>
		<s:hidden id="communicationSize" name="iamodel.communicationsList.size" value="0"/>
		<s:set name="index" value="0" />
		<article id="artCommunication" class="hidden" >
	</s:else>
		<section class="secIssue sixteen columns curveBorder">
		
			<s:hidden name="iamodel.communicationsList[%{#index}].id"/>
			<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
			
			<div class="row">
				<div class="five columns">
					<s:select list="communicationSelectList" listValue="communicationTypeName" listKey="id" name="theCommunicationsList[%{#index}]" headerKey="-1" headerValue="Select Communication Type" />
				</div>
				<div class="inputfield six columns omega">
					<s:label for="communicationDate" value="Communication Date:" />
					<div>  				
						<s:textfield id="DateId%{#index}" cssClass="DateInputClass" name="iamodel.communicationsList[%{#index}].communicationDate"/> 
		 		 	</div>
				</div>
				<div  class="inputfield four columns omega">
					<s:label for="timespent" value="Time Spent:" />
					<div>
						<s:textfield name="iamodel.communicationsList[%{#index}].timeSpent"  />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="textarea fourteen columns omega">
					<s:label for="comments" value="Communication Notes:" />
					<s:textarea cssClass="oneLineTextArea" name="iamodel.communicationsList[%{#index}].description"/> 
				</div>
				<s:hidden name="iamodel.communicationsList[%{#index}].importantFlag"/>
				<input type="button" id="btnImportant" class="one columns" name="importantFlag" onclick="importantDiv(this)"/>
			</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddCommunication" value="Add Communication" class="three columns" />
	</div>
	</div>
</div>
</section>
