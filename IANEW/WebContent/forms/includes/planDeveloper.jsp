<!-- 
 Created By: Kim To
 Created Date: 18/09/2014
 ==============================
 Modification History
 18-09-2014  by Kim To
     Moved Matt code from plan.jsp to this new file
 

 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="fieldsetborder">
<h4 class="sixteen columns"  style="float:none;">Developed By</h4>
	<article id="itDeveloper">
		<%@include file="iterPlanDevelopers.jsp" %>
	</article>
	<s:if test="%{iamodel.planDevelopersList.size > 0}">
		<article id="artDeveloper" class="row hidden">
		<s:hidden id="planDeveloperSize" name="iamodel.planDevelopersList.size" value="%{iamodel.planDevelopersList.size}"/>
		<s:set name="index" value="%{iamodel.planDevelopersList.size}" />
	</s:if>
	<s:else>
		<article id="artDeveloper" class="row hidden">
		<s:hidden id="planDeveloperSize" name="iamodel.planDevelopersList.size" value="0"/>
		<s:set name="index" value="0" />
	</s:else>
		<section class="secIssue sixteen columns curveBorder">
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
			<div class="row">
				<div class="fifteen columns">
					<s:select list="developerSelectList" listKey="id" listValue="fullName" name="theDeveloperList[%{#planDeveloperSize}]" headerKey="-1" headerValue="Select a Plan Developer"/>
				</div>
			</div>
		</section>
	</article>
<div class="row">
	<div class="thirteen columns alpha"><p></p></div>
	<input type="button" id="btnAddDeveloper" value="Add Plan Developer" class="three columns" onclick="addSection('artDeveloper', 'section', 'itDeveloper', 'planDeveloperSize'); return false;"/>
</div>
</div>	