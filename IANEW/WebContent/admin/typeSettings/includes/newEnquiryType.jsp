<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3 class="sixteen columns" style="float:none;">New Enquiry Type</h3>
	<s:url var="urlEnType" namespace="/admin" action="saveNewEnquiryType" includeContext="false"/>
	<s:url var="urlUpdateEnType" namespace="/admin" action="updateEnquiryType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="enquiryType" class="toggled hideable">
			<s:form id="newEnquiryTypeForm" method="post" action="%{urlEnType}">
				<s:label for="enquiryTypeName" value="Name: "/>
				<s:textfield id="enquiryTypeName" name="enquiryTypeName" />
				<s:label for="enquiryTypeDescription" value="Description" />
				<s:textarea id="enquiryTypeDescription" name ="enquiryTypeDescription" cols="70" rows="1"/>
				<sj:submit id="saveNewEnquiryType" targets="tbodyEnquiryType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>
			<s:form id="editEnquiryTypeForm" method="post" action="%{urlUpdateEnType}">
				<table>
					<thead>
						<tr>
							<th>Enquiry Type Name</th>
							<th>Enquiry Type Description</th>
						</tr>
					</thead>
					<tbody id="tbodyEnquiryType">
						<%@include file="iterators/iterEnquiryTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyEnquiryType" value="Update changes" id="btnEditEnquiry" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>