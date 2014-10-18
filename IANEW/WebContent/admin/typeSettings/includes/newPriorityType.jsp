<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Priority Type</h3>
	<s:url var="urlNewPriorityType" namespace="/admin" action="saveNewPriorityType" includeContext="false"/>
	<s:url var="urlUpdatePriorityType" namespace="/admin" action="updatePriorityTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="PriorityType" class="toggled hideable">
			<s:form id="newPriorityTypeForm" method="post" action="%{urlNewPriorityType}" onsubmit="clearInput()" >
				<s:label for="priorityName" value="Name: "/>
				<s:textfield id="priorityName" name="priorityName" />
				<sj:submit id="saveNewPriorityType" targets="tbodyPriorityType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>	
			<s:form id="editPriorityTypeForm" method="post" action="%{urlUpdatePriorityType}">		
				<table>
					<thead>
						<tr>
							<th>Priority Name</th>
						</tr>
					</thead>
					<tbody id="tbodyPriorityType">
						<%@include file="iterators/iterPriorityTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyPriorityType" value="Update changes" id="btnEditPriority" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>