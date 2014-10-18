<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
		<h3 class="sixteen columns" style="float:none;">New Accommodation Type</h3>
	<s:url var="urlNewAccType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	<s:url var="urlUpdateAccType" namespace="/admin" action="updateAccommodationTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="accommodationType" class="toggled hideable">
			<s:form id="newAccommodationTypeForm" method="post" action="%{urlNewAccType}">
				<s:label for="accommodationName" value="Name: "/>
				<s:textfield id="accommodationName" name="accommodationName" />
				<s:label for="accommodationDescription" value="Description" />
				<s:textarea id="accommodationDescription"  name ="accommodationDescription" cols="70" rows="1" />
				<sj:submit id="saveNewAccommodationType" targets="tbodyAccommodationType" cssClass="two columns alpha" value="Save" clearForm="true"/>
			</s:form>	
			<s:form id="editAccommodationTypeForm" method="post" action="%{urlUpdateAccType}">		
				<table>
					<thead>
						<tr>
							<th>Accommodation Name</th>
							<th>Accommodation Description</th>
						</tr>
					</thead>
					<tbody id="tbodyAccommodationType">
						<%@include file="iterators/iterAccommodationTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyAccommodationType" value="Update changes" id="btnEditAccommodation" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>