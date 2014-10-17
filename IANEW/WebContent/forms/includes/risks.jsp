<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="fieldsetborder">
	<h4 class="sixteen columns"  style="float:none;">Risks</h4>
	
		<%@include file="iterRisks.jsp" %>
	
	<s:if test="%{iamodel.risksList.size > 0}">
		<s:hidden id="riskSize" name="iamodel.risksList.size" value="%{iamodel.risksList.size}"/>
		<s:set name="index" value="iamodel.risksList.size" />
		<article id="artRisk" class="row hidden">
	</s:if>
	<s:else>
		<s:hidden id="riskSize" name="iamodel.risksList.size" value="0"/>
		<s:set name="index" value="iamodel.risksList.size" />
		<article id="artRisk" class="row hidden">
	</s:else>
		<section class="secIssue sixteen columns curveBorder">
			<s:hidden name="iamodel.risksList[%{#index}].id"/>
				<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
 
 				<div class="row">
					<div class="textarea fifteen columns omega">
						<s:label for="riskDescription" value="Risk Description" />
						<s:textarea cssClass="oneLineTextArea" name="iamodel.risksList[%{#index}].riskDescription"/> 
					</div>
				</div>			
				<div class="row">
					<div class="textarea fifteen columns omega">
						<s:label for="riskManagement" value="Risk Management" />
						<s:textarea cssClass="oneLineTextArea" name="iamodel.risksList[%{#index}].riskManagement"/> 
					</div>
				</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddRisk" value="Add Risk" class="three columns" onclick="addNewRecord('artRisk','riskSize', 'itRisk');return false;" />
	</div>
</div>