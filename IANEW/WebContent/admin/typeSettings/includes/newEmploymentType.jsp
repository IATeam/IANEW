<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Employment Type</h3>
	<s:url var="urlEmpType" namespace="/admin" action="saveNewEmploymentType" includeContext="false"/>
	<s:url var="urlUpdateEmpType" namespace="/admin" action="updateEmploymentType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="employmentType" class="toggled hideable">
			<s:form id="newEmploymentTypeForm" method="post" action="%{urlEmpType}">
				<s:label for="employmentName" value="Name: "/>
				<s:textfield id="employmentName" name="employmentName" />
				<s:label for="employmentDescription" value="Description" />
				<s:textarea id="employmentDescription" name ="employmentDescription" cols="70" rows="1"/>
				<sj:submit id="saveNewEmployment" targets="tbodyEmploymentType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editEmploymentTypeForm" method="post" action="%{urlUpdateEmpType}">
				<table>
					<thead>
						<tr>
							<th>Employment Name</th>
							<th>Employment Description</th>
						</tr>
					</thead>
					<tbody id="tbodyEmploymentType">
						<%@include file="iterators/iterEmploymentTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyEmploymentType" value="Update changes" id="btnEditEmployment" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>