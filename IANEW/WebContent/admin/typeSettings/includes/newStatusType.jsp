<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Status Type</h3>
	<s:url var="urlStaType" namespace="/admin" action="saveNewStatusType" includeContext="false"/>
	<s:url var="urlUpdateStaType" namespace="/admin" action="updateStatusType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="statusType" class="toggled hideable">
			<s:form id="newStatusTypeForm" method="post" action="%{urlStaType}">
				<s:label for="statusName" value="Name: "/>
				<s:textfield id="statusName" name="statusName" />
				<sj:submit id="saveNewStatus" targets="tbodyStatusType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editStatusTypeForm" method="post" action="%{urlUpdateStaType}">
				<table>
					<thead>
					<tr>
						<th>Status Name</th>
					</tr>
					</thead>
					<tbody id="tbodyStatusType">
						<%@include file="iterators/iterStatusTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyStatusType" value="Update changes" id="btnEditStatus" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>	
		</div>
	</div>
	</section>