<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Accommodation Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Accommodation Type</h3>
	<s:url var="urlNewAccType" namespace="/admin" action="saveNewAccommodationType" includeContext="false"/>
	<s:url var="urlUpdateAccType" namespace="/admin" action="updateAccommodationTypes" includeContext="false"/>

	<div class="greybackground">
		<div id="accommodationType" class="toggled hideable">
			<s:form id="newAccommodationTypeForm" method="post" action="%{urlNewAccType}" onsubmit="clearInput()" >
				<s:label for="accommodationName" value="Name: "/>
				<s:textfield id="accommodationName" name="accommodationName" />
				<s:label for="accommodationDescription" value="Description" />
				<s:textarea id="accommodationDescription"  name ="accommodationDescription" cols="70" rows="1" />
				<sj:submit id="saveNewAccommodationType" targets="tbodyAccommodationType" cssClass="two columns alpha" value="Save" />
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
						<%@include file="iterAccommodationTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyAccommodationType" value="Update changes" id="btnEditAccommodation" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>