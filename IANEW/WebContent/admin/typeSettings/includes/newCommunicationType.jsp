<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Communication Type</h3>
	<s:url var="urlNewComType" namespace="/admin" action="saveNewCommunicationType" includeContext="false"/>
	<s:url var="urlUpdateComType" namespace="/admin" action="updateCommunicationTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="communicationType" class="toggled hideable">
			<s:form id="newCommunicationTypeForm" method="post" action="%{urlNewComType}">
				<s:label for="communicationTypeName" value="Name: "/>
				<s:textfield id="communicationTypeName" name="communicationTypeName" />
				<sj:submit id="saveNewCommunicationType" targets="tbodyCommunicationType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>	
			<s:form id="editCommunicationTypeForm" method="post" action="%{urlUpdateComType}">		
				<table>
					<thead>
						<tr>
							<th>Communication Name</th>
						</tr>
					</thead>
					<tbody id="tbodyCommunicationType">
						<%@include file="iterators/iterCommunicationTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyCommunicationType" value="Update changes" id="btnEditCommunication" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>