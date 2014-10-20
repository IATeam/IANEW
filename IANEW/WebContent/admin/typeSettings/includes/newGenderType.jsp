<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Gender Type</h3>
	<s:url var="urlGenType" namespace="/admin" action="saveNewGenderType" includeContext="false"/>
	<s:url var="urlUpdateGenType" namespace="/admin" action="updateGenderType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="genderType" class="toggled hideable">
			<s:form id="newGenderTypeForm" method="post" action="%{urlGenType}">		
				<s:label for="genderName" value="Name: "/>
				<s:textfield id="genderName" name="genderName" />
				<s:label for="genderCode" value="Code" />
				<s:textarea id="genderCode" name ="genderCode" cols="70" rows="1"/>
				<sj:submit id="saveNewGender" targets="tbodyGenderType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editGenderTypeForm" method="post" action="%{urlUpdateGenType}">
				<table>
					<thead>
					<tr>
						<th>Gender Name</th>
						<th>Gender Code</th>
					</tr>
					</thead>
					<tbody id="tbodyGenderType">
						<%@include file="iterators/iterGenderTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyGenderType" value="Update changes" id="btnEditGender" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>