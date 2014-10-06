<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="fieldsetborder">
	<h4 class="sixteen columns"  style="float:none;">Risks</h4>
	
		<%@include file="iterRisks.jsp" %>
	
	<s:hidden id="riskSize" name="iamodel.risksList.size" value="%{iamodel.risksList.size}"/>
	<s:set name="index" value="iamodel.risksList.size" />
	<article id="artRisk" class="row" style="visibility: hidden; display: none;">
		<section class="secIssue sixteen columns curveBorder">
			<s:hidden name="iamodel.risksList[%{#index}].id"/>
			<input type="image" src="/IANEW/resources/images/undoButtonImage.png" alt="undoButton" id="btnUndo" value="Undo" onclick="return false;" class="undoButton"/>
			<div class="row">
					<div class="textarea fifteen columns omega">
						<s:label for="riskDescription" value="Risk Description" />
						<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
					</div>
				</div>			
				<div class="row">
					<div class="textarea fifteen columns omega">
						<s:label for="riskManagement" value="Risk Management" />
						<s:textarea id="" cssClass="oneLineTextArea" name=""/> 
					</div>
				</div>
		</section>
	</article>
	<div class="row">
		<div class="thirteen columns alpha"><p></p></div>
		<input type="button" id="btnAddRisk" value="Add Risk" class="three columns" />
	</div>

	<script>
	$(function(){
		$("#btnAddRisk").click(function(){ 
			$("#artRisk section").clone().appendTo("#itRisk");
		});
	});
	</script>
</div>