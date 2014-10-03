<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Gender Type</title>
</head>
<body>
<section>
<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Gender Type</h3>
	<s:url var="urlGenType" namespace="/admin" action="saveNewGenderType" includeContext="false"/>
	<s:url var="urlUpdateGenType" namespace="/admin" action="updateGenderType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="genderType" class="toggled hideable">
			<s:form id="newGenderTypeForm" method="post" action="%{urlGenType}">		
				<s:label for="genderName" value="Name: "/>
				<s:textfield id="genderName" name="genderName" />
				<s:label for="genderCode" value="Code" />
				<s:textarea id="genderCode" name ="genderCode" />
				<sj:submit id="saveNewGender" targets="tbodyGenderType" cssClass="two columns alpha" value="Save"/>
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
						<%@include file="iterGenderTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyGenderType" value="Update changes" id="btnEditGender" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>
		</div>
	</div>
	</section>
</body>
</html>