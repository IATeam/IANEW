<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Danger Type</h3>
	<s:url var="urlDanType" namespace="/admin" action="saveNewDangerType" includeContext="false"/>
	<s:url var="urlUpdateDanType" namespace="/admin" action="updateDangerType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="dangerType" class="toggled hideable">
			<s:form id="newDangerTypeForm" method="post" action="%{urlDanType}">
				<s:label for="dangerName" value="Name: "/>
				<s:textfield id="dangerName" name="dangerName" />
				<s:label for="dangerDescription" value="Description" />
				<s:textarea id="dangerDescription" name ="DangerDescription" cols="70" rows="1" />
				<sj:submit id="saveNewDangerType" targets="tbodyDangerType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editDangerTypeForm" method="post" action="%{urlUpdateDanType}">
				<table>
					<thead>
						<tr>
							<th>Danger Name</th>
							<th>Danger Description</th>
						</tr>
					</thead>
					<tbody id="tbodyDangerType">
						<%@include file="iterators/iterDangerTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyDangerType" value="Update changes" id="btnEditDanger" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>		
		</div>
	</div>
	</section>