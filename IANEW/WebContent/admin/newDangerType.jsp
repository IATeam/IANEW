<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Danger Type</title>
</head>
<body>
	<section>
	<input type="image" src="/IANEW/resources/images/plusButton.png" alt="Hide/Show" id="btnShowHide" value="ShowHide" onclick="divHide(this);return false;" class="divHideButton"/>
	<h3>New Danger Type</h3>
	
	<s:url var="urlDanType" namespace="/admin" action="saveNewDangerType" includeContext="false"/>
	<s:url var="urlUpdateDanType" namespace="/admin" action="updateDangerType" includeContext="false"/>
	
	<div class="greybackground">
		<div id="dangerType" class="toggled hideable">
			<s:form id="newDangerTypeForm" method="post" action="%{urlDanType}">
				<s:label for="dangerName" value="Name: "/>
				<s:textfield id="dangerName" name="dangerName" />
				<s:label for="dangerDescription" value="Description" />
				<s:textarea id="dangerDescription" name ="DangerDescription" />
				<sj:submit id="saveNewDangerType" targets="tbodyDangerType" cssClass="two columns alpha" value="Save"/>
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
						<%@include file="iterDangerTypes.jsp" %>
					</tbody>
				</table>
				<sj:submit targets = "tbodyDangerType" value="Update changes" id="btnEditDanger" cssClass="hidden" onclick="hideBtn(this)"/>
			</s:form>		
		</div>
	</div>
	</section>
</body>
</html>