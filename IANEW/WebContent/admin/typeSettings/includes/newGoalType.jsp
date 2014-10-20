<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Goal Type</h3>
	<s:url var="urlNewGoalType" namespace="/admin" action="saveNewGoalType" includeContext="false"/>
	<s:url var="urlUpdateGoalType" namespace="/admin" action="updateGoalTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="goalType" class="toggled hideable">
			<s:form id="newGoalTypeForm" method="post" action="%{urlNewGoalType}" onsubmit="clearInput()" >
				<s:label for="goalTypeName" value="Name: "/>
				<s:textfield id="goalTypeName" name="goalTypeName" />
				<sj:submit id="saveNewGoalType" targets="tbodyGoalType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>	
			<s:form id="editGoalTypeForm" method="post" action="%{urlUpdateGoalType}">		
				<table>
					<thead>
						<tr>
							<th>Goal Name</th>
						</tr>
					</thead>
					<tbody id="tbodyGoalType">
						<%@include file="iterators/iterGoalTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyGoalType" value="Update changes" id="btnEditGoal" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>