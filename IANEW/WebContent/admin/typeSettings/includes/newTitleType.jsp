<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Title Type</h3>
	
	<s:url var="urlTiType" namespace="/admin" action="saveNewTitleType" includeContext="false"/>
	<s:url var="urlUpdateTiType" namespace="/admin" action="updateTitleType" includeContext="false"/>
	
	<div class="greybackground">
			<div id="titleType" class="toggled hideable">
				<s:form id="newTitleTypeForm" method="post" action="%{urlTiType}">
					<s:label for="titleName" value="Name: "/>
					<s:textfield id="titleName" name="titleName" />
					<sj:submit id="saveNewTitleType" targets="tbodyTitleType" cssClass="two columns alpha" value="Save" clearForm="true"/>
				</s:form>
				<s:form id="editTitleTypeForm" method="post" action="%{urlUpdateTiType}">
					<table>
						<thead>
							<tr>
								<th>Title Name</th>
							</tr>
						</thead>
						<tbody id="tbodyTitleType">
							<%@include file="iterators/iterTitleTypes.jsp" %>
						</tbody>
					</table>
					<sj:submit targets = "tbodyTitleType" value="Update changes" id="btnEditTitle" cssClass="hidden" onclick="hideBtn(this)"/>
				</s:form>
			</div>
		</div>
		</section>