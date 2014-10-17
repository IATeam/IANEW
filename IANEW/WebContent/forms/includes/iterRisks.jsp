<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<article id="itRisk">
<s:iterator value="iamodel.risksList" status="stat">		
	<section class="secIssue sixteen columns curveBorder">
		<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="undoButton(this);return false;" class="undoButton"/>
		<s:hidden name="iamodel.risksList[%{#stat.index}].id"/>
		<div class="row">
			<div class="textarea fifteen columns omega">
				<s:label for="riskDescription" value="Risk Description" />
				<s:textarea cssClass="oneLineTextArea" name="iamodel.risksList[%{#stat.index}].riskDescription"/> 
			</div>
		</div>			
		<div class="row">
			<div class="textarea fifteen columns omega">
				<s:label for="riskManagement" value="Risk Management" />
				<s:textarea cssClass="oneLineTextArea" name="iamodel.risksList[%{#stat.index}].riskManagement"/> 
			</div>
		</div>
	</section>
</s:iterator>

	</article>